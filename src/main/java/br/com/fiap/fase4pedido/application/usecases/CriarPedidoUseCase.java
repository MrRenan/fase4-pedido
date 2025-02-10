package br.com.fiap.fase4pedido.application.usecases;

import br.com.fiap.fase4pedido.domain.entities.ItemPedidoEntity;
import br.com.fiap.fase4pedido.domain.entities.PedidoEntity;
import br.com.fiap.fase4pedido.domain.entities.StatusPedido;
import br.com.fiap.fase4pedido.domain.repositories.PedidoRepository;
import br.com.fiap.fase4pedido.interfaceadapters.dtos.ItemPedidoRecordDTO;
import br.com.fiap.fase4pedido.interfaceadapters.dtos.PedidoRecordDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CriarPedidoUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;
    //@Autowired
    //private ClienteRepository clienteRepository;
    //@Autowired
    //private ProdutoRepository produtoRepository;

    @Transactional
    public PedidoEntity executar(PedidoRecordDTO pedidoDTO) {
        // 1. Recuperar o cliente
        //ClienteEntity cliente = clienteRepository.findById(pedidoDTO.clienteId())
               // .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        // 2. Criar o pedido
        PedidoEntity pedido = new PedidoEntity();
        //pedido.setClienteEntity(cliente);
        pedido.setDataPedidoEntity(LocalDateTime.now());
        pedido.setStatus(StatusPedido.PENDENTE);

        // 3. Criar os itens do pedido
//        List<ItemPedidoEntity> itensPedido = pedidoDTO.itens().stream()
//                .map(itemDTO -> {
//                    //ProdutoEntity produtoEntity = produtoRepository.findById(ItemPedidoRecordDTO.produtoId())
//                            //.orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
//                    ItemPedidoEntity item = new ItemPedidoEntity();
//                    item.setPedido(pedido);
//                   // item.setProduto(produto);
////                    item.setQuantidade(itemDTO.quantidade());
////                    return item;
//                })
//
//                .collect(Collectors.toList());
//        pedido.setItens(itensPedido);

        // 4. Salvar o pedido
        return pedidoRepository.save(pedido);
    }
    }
