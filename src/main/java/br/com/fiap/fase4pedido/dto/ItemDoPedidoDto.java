package br.com.fiap.fase4pedido.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ItemDoPedidoDto {

    private Long id;
    private Integer quantidade;
    private String descricao;
}

