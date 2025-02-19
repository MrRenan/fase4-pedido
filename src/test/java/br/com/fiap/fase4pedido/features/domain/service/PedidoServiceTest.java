package br.com.fiap.fase4pedido.features.domain.service;

import br.com.fiap.fase4pedido.features.adapter.out.PedidoAdapter;
import br.com.fiap.fase4pedido.features.domain.entity.Cliente;
import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.features.domain.entity.Produto;
import br.com.fiap.fase4pedido.features.domain.entity.Status;
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
public class PedidoServiceTest {

    @Mock
    private PedidoAdapter pedidoAdapter;

    @InjectMocks
    private PedidoService pedidoService;

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

        when(pedidoAdapter.criarPedido(any(Pedido.class))).thenReturn(pedido);

        // Act
        Pedido resultado = pedidoService.criarPedido(pedido);

        // Assert
        assertNotNull(resultado);
        assertEquals(Status.CRIADO, resultado.getStatus());
        verify(pedidoAdapter, times(1)).criarPedido(any(Pedido.class));
    }

    @Test
    public void testPagarPedido() {
        // Arrange
        Pedido pedido = new Pedido(
                "1",
                new Cliente("1", "João"),
                Collections.singletonList(new Produto("1", "Produto A", BigDecimal.valueOf(100), 2)),
                LocalDate.now(),
                Status.PAGO,
                BigDecimal.valueOf(200)
        );

        when(pedidoAdapter.obterPedidoPorId("1")).thenReturn(pedido);
        when(pedidoAdapter.atualizarPedido(any(Pedido.class))).thenReturn(pedido);

        // Act
        Pedido resultado = pedidoService.pagarPedido("1");

        // Assert
        assertNotNull(resultado);
        assertEquals(Status.PAGO, resultado.getStatus());
        verify(pedidoAdapter, times(1)).obterPedidoPorId("1");
        verify(pedidoAdapter, times(1)).atualizarPedido(any(Pedido.class));
    }
}