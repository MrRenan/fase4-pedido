package br.com.fiap.fase4pedido.features.adapter.out;

import br.com.fiap.fase4pedido.features.adapter.out.mapper.PedidoMapper;
import br.com.fiap.fase4pedido.features.domain.entity.Cliente;
import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.features.domain.entity.Produto;
import br.com.fiap.fase4pedido.features.domain.exception.exception.ClienteNaoEncontradoException;
import br.com.fiap.fase4pedido.features.domain.exception.exception.EstoqueInsuficienteException;
import br.com.fiap.fase4pedido.features.domain.exception.exception.PedidoNaoEncontradoException;
import br.com.fiap.fase4pedido.features.domain.exception.exception.ProdutoNaoEncontradoException;
import br.com.fiap.fase4pedido.features.port.PedidoPort;
import br.com.fiap.fase4pedido.infra.mongodb.document.PedidoDocument;
import br.com.fiap.fase4pedido.infra.mongodb.repository.PedidoRepository;
import br.com.fiap.fase4pedido.infra.rabbitmq.PedidoPublisher;
import br.com.fiap.fase4pedido.infra.restclient.cliente.ClienteClient;
import br.com.fiap.fase4pedido.infra.restclient.cliente.entity.ClienteEntity;
import br.com.fiap.fase4pedido.infra.restclient.produto.ProdutoClient;
import br.com.fiap.fase4pedido.infra.restclient.produto.entity.EstoqueEntity;
import br.com.fiap.fase4pedido.infra.restclient.produto.entity.ProdutoEntity;
import br.com.fiap.fase4pedido.infra.restclient.produto.entity.ProdutoEstoque;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static br.com.fiap.fase4pedido.features.domain.entity.Status.CRIADO;
import static br.com.fiap.fase4pedido.features.domain.entity.Status.PAGO;
import static java.time.LocalDate.now;

@Component
@RequiredArgsConstructor
public class PedidoAdapter implements PedidoPort {

    private final ClienteClient clienteClient;
    private final ProdutoClient produtoClient;
    private final PedidoRepository pedidoRepository;
    private final PedidoMapper mapper;
    private final PedidoPublisher pedidoPublisher;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        ClienteEntity clienteEntity = obterCliente(pedido.getCliente().getId());
        Cliente cliente = mapper.paraCliente(clienteEntity);
        List<Produto> produtoList = pedido.getProdutos()
                .stream()
                .map(this::obterProduto)
                .map(mapper::paraProduto).toList();

        Pedido novoPedido = new Pedido();
        novoPedido.setCliente(cliente);
        novoPedido.setProdutos(produtoList);
        novoPedido.setDataCriacao(now());
        novoPedido.setStatus(CRIADO);
        novoPedido.setTotal(calcularTotal(produtoList));

        List<ProdutoEstoque> produtoEstoqueList = produtoList.stream()
                .map(produto -> new ProdutoEstoque(produto.getId(), produto.getQuantidade()))
                .toList();

        EstoqueEntity estoqueEntity = new EstoqueEntity(produtoEstoqueList);

        try {
            produtoClient.atualizarEstoque(estoqueEntity);
        } catch (RuntimeException e) {
            throw new EstoqueInsuficienteException("Erro ao atualizar estoque.");
        }

        PedidoDocument pedidoDocument = pedidoRepository.save(mapper.paraPedidoDocument(novoPedido));
        return mapper.paraPedido(pedidoDocument);
    }

    @Override
    public List<Pedido> obterPedidos() {
        List<PedidoDocument> pedidoDocumentList = pedidoRepository.findAll();
        return pedidoDocumentList.stream().map(mapper::paraPedido).toList();
    }

    @Override
    public Pedido obterPedidoPorId(String id) {
        Optional<PedidoDocument> pedidoDocument = pedidoRepository.findById(id);
        return pedidoDocument.map(mapper::paraPedido)
                .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado com o ID: " + id));
    }

    @Override
    public Pedido atualizarPedido(Pedido pedido) {
        PedidoDocument pedidoDocument = mapper.paraPedidoDocument(pedido);
        pedidoDocument = pedidoRepository.save(pedidoDocument);
        return mapper.paraPedido(pedidoDocument);
    }

    @Override
    public Pedido pagarPedido(String id) {
        Pedido pedido = obterPedidoPorId(id);
        pedido.setStatus(PAGO);
        PedidoDocument pedidoDocument = pedidoRepository.save(mapper.paraPedidoDocument(pedido));
        pedidoPublisher.enviarPedidoPago(pedidoDocument.id());
        return mapper.paraPedido(pedidoDocument);
    }

    @Override
    public void excluirPedido(String id) {
        Pedido pedido = obterPedidoPorId(id);
        pedidoRepository.delete(mapper.paraPedidoDocument(pedido));
    }

    private BigDecimal calcularTotal(List<Produto> produtoList) {
        BigDecimal total = BigDecimal.ZERO;
        for (Produto produto : produtoList) {
            BigDecimal precoProduto = produto.getPreco();
            BigDecimal quantidade = BigDecimal.valueOf(produto.getQuantidade());
            total = total.add(precoProduto.multiply(quantidade));
        }
        return total;
    }

    private ClienteEntity obterCliente(String id) {
        try {
            return clienteClient.obterCliente(id);
        } catch (RuntimeException e) {
            throw new ClienteNaoEncontradoException("Erro ao obter cliente: " + id);
        }
    }

    private ProdutoEntity obterProduto(Produto produto) {
        try {
            ProdutoEntity produtoEntity = produtoClient.obterProduto(produto.getId());
            produtoEntity.setQuantidade(produto.getQuantidade());
            return produtoEntity;
        } catch (RuntimeException e) {
            throw new ProdutoNaoEncontradoException("Erro ao obter produto: " + produto.getId());
        }
    }
}