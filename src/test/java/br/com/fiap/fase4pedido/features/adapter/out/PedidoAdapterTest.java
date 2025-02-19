package br.com.fiap.fase4pedido.features.adapter.out;

import br.com.fiap.fase4pedido.features.adapter.out.mapper.PedidoMapper;
import br.com.fiap.fase4pedido.features.domain.entity.Cliente;
import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.features.domain.entity.Produto;
import br.com.fiap.fase4pedido.features.domain.entity.Status;
import br.com.fiap.fase4pedido.infra.mongodb.document.PedidoDocument;
import br.com.fiap.fase4pedido.infra.mongodb.repository.PedidoRepository;
import br.com.fiap.fase4pedido.infra.restclient.cliente.ClienteClient;
import br.com.fiap.fase4pedido.infra.restclient.cliente.entity.ClienteEntity;
import br.com.fiap.fase4pedido.infra.restclient.produto.ProdutoClient;
import br.com.fiap.fase4pedido.infra.restclient.produto.entity.ProdutoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PedidoAdapterTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ClienteClient clienteClient;

    @Mock
    private ProdutoClient produtoClient;

    @Mock
    private PedidoMapper pedidoMapper;

    @InjectMocks
    private PedidoAdapter pedidoAdapter;

    @Test
    public void testCriarPedido() {
        // Arrange
        Pedido pedido = new Pedido(
                "1",
                new Cliente("1", "João"),
                Collections.singletonList(new Produto("1", "Produto A", BigDecimal.valueOf(100), 2)),
                LocalDate.now(),
                Status.CRIADO,
                BigDecimal.valueOf(200)
        );

        PedidoDocument pedidoDocument = new PedidoDocument(
                "1",
                new PedidoDocument.ClienteDocument("1", "João"),
                Collections.singletonList(new PedidoDocument.ProdutoDocument("1", "Produto A", BigDecimal.valueOf(100), 2)),
                LocalDate.now(),
                "CRIADO",
                BigDecimal.valueOf(200)
        );

        when(clienteClient.obterCliente("1")).thenReturn(new ClienteEntity("1", "João"));
        when(produtoClient.obterProduto(any())).thenReturn(new ProdutoEntity("1", "Produto A", BigDecimal.valueOf(100), 2));
        when(pedidoMapper.paraProduto(any(ProdutoEntity.class))).thenReturn(new Produto("1", "Produto A", BigDecimal.valueOf(100), 2)); // Mock do mapper
        when(pedidoMapper.paraPedidoDocument(any(Pedido.class))).thenReturn(pedidoDocument);
        when(pedidoRepository.save(any(PedidoDocument.class))).thenReturn(pedidoDocument);
        when(pedidoMapper.paraPedido(any(PedidoDocument.class))).thenReturn(pedido);

        // Act
        Pedido resultado = pedidoAdapter.criarPedido(pedido);

        // Assert
        assertNotNull(resultado);
        assertEquals(Status.CRIADO, resultado.getStatus());
        verify(pedidoRepository, times(1)).save(any(PedidoDocument.class));
        verify(pedidoMapper, times(1)).paraPedidoDocument(any(Pedido.class)); // Verifica se o mapper foi chamado
        verify(pedidoMapper, times(1)).paraPedido(any(PedidoDocument.class)); // Verifica se o mapper foi chamado
    }
}