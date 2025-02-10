package br.com.fiap.fase4pedido.interfaceadapters.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoRecordDTO(
        Long clienteId,
        LocalDateTime dataPedido,
        List<ItemPedidoRecordDTO> itens
) {
}
