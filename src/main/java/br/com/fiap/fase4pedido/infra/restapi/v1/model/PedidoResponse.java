package br.com.fiap.fase4pedido.infra.restapi.v1.model;

import br.com.fiap.fase4pedido.features.domain.entity.Produto;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
public record PedidoResponse(

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
            String nomeProduto,
            BigDecimal preco,
            int quantidade
    ) {

    }
}
