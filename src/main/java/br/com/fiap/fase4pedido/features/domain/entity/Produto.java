package br.com.fiap.fase4pedido.features.domain.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Produto {
    private String nomeProduto;
    private String preco;
    private String quantidade;
}
