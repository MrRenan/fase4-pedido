package br.com.fiap.fase4pedido.features.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    private String id;
    private String nomeProduto;
    private BigDecimal preco;
    private int quantidade;

}