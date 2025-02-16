package br.com.fiap.fase4pedido.controller;

import br.com.fiap.fase4pedido.dto.ItemDoPedidoDto;
import br.com.fiap.fase4pedido.dto.PedidoDto;
import br.com.fiap.fase4pedido.service.PedidoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

        @ExtendWith(MockitoExtension.class) // Habilita o Mockito
        public class PedidoControllerTest {

            @Mock  // Cria um mock do PedidoService
            private PedidoService service;

            @InjectMocks // Injeta o mock 'service' no PedidoController
            private PedidoController controller;

            @Test
            public void listarTodos_DeveRetornarListaDePedidos() {
                // 1. Arrange (Preparação)
                // Define o comportamento simulado do PedidoService
                PedidoDto pedido1 = new PedidoDto();
                pedido1.setId(1L);
                //pedido1.setDescricao("Pedido 1");
                listarTodos_DeveRetornarListaDePedidos();

                PedidoDto pedido2 = new PedidoDto();
                pedido2.setId(2L);
                //pedido2.setDescricao("Pedido 2");
                listarTodos_DeveRetornarListaDePedidos();

                List<PedidoDto> pedidosSimulados = Arrays.asList(pedido1, pedido2);

                // Quando o método obterTodos() do 'service' for chamado, retorne 'pedidosSimulados'
                when(service.obterTodos()).thenReturn(pedidosSimulados);

                // 2. Act (Ação)
                // Chama o método que você quer testar
                List<PedidoDto> resultado = controller.listarTodos();

                // 3. Assert (Verificação)
                // Verifica se o resultado é o que você esperava
                assertEquals(2, resultado.size()); // Verifica se o tamanho da lista está correto
                //assertEquals("ItemDoPedido 1", resultado.get(0).getDescricao()); // Verifica um valor específico
                //assertEquals("Pedido 2", resultado.get(1).getDescricao()); // Verifica outro valor específico
            }

            @Test
            public void listarTodos_DeveRetornarListaVazia() {
                // Arrange
                when(service.obterTodos()).thenReturn(List.of());

                // Act
                List<PedidoDto> resultado = controller.listarTodos();

                // Assert
                assertEquals(0, resultado.size());
            }
        }

