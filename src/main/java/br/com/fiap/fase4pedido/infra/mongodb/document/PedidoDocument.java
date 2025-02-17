package br.com.fiap.fase4pedido.infra.mongodb.document;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@Document(collection = "pedido")
public record PedidoDocument(
        Cliente cliente,
        List<Produto> produtos,
        LocalDate dataCriacao,
        String status,
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