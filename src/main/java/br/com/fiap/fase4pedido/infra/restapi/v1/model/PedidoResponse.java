package br.com.fiap.fase4pedido.infra.restapi.v1.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
public record PedidoResponse(

        String id,
        Cliente cliente,
        List<Produto> produtos,
        LocalDate dataCriacao,
        Status status,
        BigDecimal total
) {
    public record Cliente (
            String id,
            String nome
    ){

    }

    public record Produto (
            String id,
            String nomeProduto,
            BigDecimal preco,
            int quantidade
    ) {

    }
}
