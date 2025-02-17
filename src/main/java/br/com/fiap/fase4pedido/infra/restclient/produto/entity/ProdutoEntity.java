package br.com.fiap.fase4pedido.infra.restclient.produto.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class ProdutoEntity {

    private String id;
    private String nomeProduto;
    private BigDecimal preco;
    private int quantidade;

}