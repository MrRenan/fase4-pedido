package br.com.fiap.fase4pedido.dto;

import br.com.fiap.fase4pedido.model.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PedidoDtoTest {

    @Test
    public void testPedidoDtoGettersAndSetters() {
        // Arrange
        PedidoDto pedidoDto = new PedidoDto();
        Long id = 1L;
        LocalDateTime dataHora = LocalDateTime.now();
        Status status = Status.ABERTO;
        List<ItemDoPedidoDto> itens = new ArrayList<>();
        ItemDoPedidoDto item1 = new ItemDoPedidoDto();
        item1.setDescricao("Item 1");
        itens.add(item1);

        // Act
        pedidoDto.setId(id);
        pedidoDto.setDataHora(dataHora);
        pedidoDto.setStatus(status);
        pedidoDto.setItens(itens);

        // Assert
        assertEquals(id, pedidoDto.getId());
        assertEquals(dataHora, pedidoDto.getDataHora());
        assertEquals(status, pedidoDto.getStatus());
        assertEquals(itens, pedidoDto.getItens());
        assertEquals("Item 1", pedidoDto.getItens().get(0).getDescricao());

    }

    @Test
    public void testPedidoDtoConstructor() {
        // Arrange
        Long id = 2L;
        LocalDateTime dataHora = LocalDateTime.now().minusDays(1);
        Status status = Status.CONCLUIDO;
        List<ItemDoPedidoDto> itens = new ArrayList<>();
        ItemDoPedidoDto item2 = new ItemDoPedidoDto();
        item2.setDescricao("Item 2");
        itens.add(item2);

        // Act
        PedidoDto pedidoDto = new PedidoDto(id, dataHora, status, itens);

        // Assert
        assertEquals(id, pedidoDto.getId());
        assertEquals(dataHora, pedidoDto.getDataHora());
        assertEquals(status, pedidoDto.getStatus());
        assertEquals(itens, pedidoDto.getItens());
        assertEquals("Item 2", pedidoDto.getItens().get(0).getDescricao());

    }

    @Test
    public void testItensListInitialization() {
        // Arrange & Act
        PedidoDto pedidoDto = new PedidoDto();

        // Assert
        assertNotNull(pedidoDto.getItens());  // Garante que a lista 'itens' foi inicializada
    }
}