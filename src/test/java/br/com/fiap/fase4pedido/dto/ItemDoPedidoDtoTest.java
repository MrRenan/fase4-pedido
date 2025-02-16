package br.com.fiap.fase4pedido.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class ItemDoPedidoDtoTest {

        @Test
        public void testItemDoPedidoDtoGettersAndSetters() {
            // Arrange
            ItemDoPedidoDto itemDto = new ItemDoPedidoDto();
            Long id = 1L;
            Integer quantidade = 2;
            String descricao = "Item de Teste";

            // Act
            itemDto.setId(id);
            itemDto.setQuantidade(quantidade);
            itemDto.setDescricao(descricao);

            // Assert
            assertEquals(id, itemDto.getId());
            assertEquals(quantidade, itemDto.getQuantidade());
            assertEquals(descricao, itemDto.getDescricao());
        }

        @Test
        public void testItemDoPedidoDtoConstructor() {
            // Arrange
            Long id = 2L;
            Integer quantidade = 3;
            String descricao = "Outro Item de Teste";

            // Act
            ItemDoPedidoDto itemDto = new ItemDoPedidoDto(id, quantidade, descricao);

            // Assert
            assertEquals(id, itemDto.getId());
            assertEquals(quantidade, itemDto.getQuantidade());
            assertEquals(descricao, itemDto.getDescricao());
        }
    }
  
