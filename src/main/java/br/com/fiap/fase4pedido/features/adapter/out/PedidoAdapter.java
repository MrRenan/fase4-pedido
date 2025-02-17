package br.com.fiap.fase4pedido.features.adapter.out;

import br.com.fiap.fase4pedido.features.adapter.out.mapper.PedidoMapper;
import br.com.fiap.fase4pedido.features.domain.entity.Cliente;
import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.features.domain.entity.Produto;
import br.com.fiap.fase4pedido.features.port.PedidoPort;
import br.com.fiap.fase4pedido.infra.mongodb.document.PedidoDocument;
import br.com.fiap.fase4pedido.infra.mongodb.repository.PedidoRepository;
import br.com.fiap.fase4pedido.infra.restclient.cliente.ClienteClient;
import br.com.fiap.fase4pedido.infra.restclient.cliente.entity.ClienteEntity;
import br.com.fiap.fase4pedido.infra.restclient.produto.ProdutoClient;
import br.com.fiap.fase4pedido.infra.restclient.produto.entity.ProdutoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

import static br.com.fiap.fase4pedido.features.domain.entity.Status.CRIADO;
import static java.time.LocalDate.now;

@Component
@RequiredArgsConstructor
public class PedidoAdapter implements PedidoPort {

    private final ClienteClient clienteClient;
    private final ProdutoClient produtoClient;
    private final PedidoRepository produtoRepository;
    private final PedidoMapper mapper;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        Pedido novoPedido = new Pedido();

        ClienteEntity clienteEntity = obterCliente(pedido.getCliente().getId());
        Cliente cliente = mapper.paraCliente(clienteEntity);
        List<Produto> produtoList = pedido.getProdutos()
                .stream()
                .map(this::obterProduto)
                .map(mapper::paraProduto).toList();

        novoPedido.setCliente(cliente);
        novoPedido.setStatus(CRIADO);
        novoPedido.setProdutos(produtoList);
        novoPedido.setDataCriacao(now());
        novoPedido.setTotal(calcularTotal(produtoList));
        PedidoDocument pedidoDocument = produtoRepository.save(mapper.paraPedidoDocument(novoPedido));
        return mapper.paraPedido(pedidoDocument);
    }

    @Override
    public List<Pedido> obterPedidos() {
        List<PedidoDocument> pedidoDocumentList = produtoRepository.findAll();
        return pedidoDocumentList.stream().map(mapper::paraPedido).toList();
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
            throw new RuntimeException("Erro ao obter cliente", e);
        }
    }

    private ProdutoEntity obterProduto(Produto produto) {
        try {
            ProdutoEntity produtoEntity = produtoClient.obterProduto(produto.getId());
            produtoEntity.setQuantidade(produto.getQuantidade());
            return produtoEntity;
        }catch (RuntimeException e) {
            throw new RuntimeException("Erro ao obter produto", e);
        }
    }

}