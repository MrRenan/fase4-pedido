package br.com.fiap.fase4pedido.features.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class Cliente {

    private String id;
    private String nome;

}