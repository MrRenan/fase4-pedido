package br.com.fiap.fase4pedido.features.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class Produto {

    private String id;
    private String nomeProduto;
    private BigDecimal preco;
    private int quantidade;

}