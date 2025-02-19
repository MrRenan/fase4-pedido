package br.com.fiap.fase4pedido.infra.mongodb.document;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@Document(collection = "pedido")
public record PedidoDocument (

        String id,
    ClienteDocument cliente,
    List<ProdutoDocument> produtos,
    LocalDate dataCriacao,
    String status,
    BigDecimal total
){

    @Builder
    public record ClienteDocument(
        String id,
        String nome
    ) {
    }

    @Builder
    public record ProdutoDocument(
        String id,
        String nomeProduto,
        BigDecimal preco,
        int quantidade
    ) {


    }
}
