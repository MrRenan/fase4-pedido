package br.com.fiap.fase4pedido.dto;


import br.com.fiap.fase4pedido.model.Status;
import lombok.*;

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