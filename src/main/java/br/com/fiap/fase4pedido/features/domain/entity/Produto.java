package br.com.fiap.fase4pedido.features.domain.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class Produto {
    private String id;
    private String nomeProduto;
    private BigDecimal preco;
    private int quantidade;
}
