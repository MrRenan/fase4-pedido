package br.com.fiap.fase4pedido.features.domain.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Cliente {
    private String id;
    private String nome;
}
