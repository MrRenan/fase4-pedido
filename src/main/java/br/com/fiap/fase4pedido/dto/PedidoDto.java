package br.com.fiap.fase4pedido.dto;

import ch.qos.logback.core.status.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {


        private Long id;
        private LocalDateTime dataHora;
        private Status status;
        private List<ItemDoPedidoDto> itens = new ArrayList<>();
}
