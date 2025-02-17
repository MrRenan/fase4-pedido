package br.com.fiap.fase4pedido.infra.restclient.cliente.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClienteEntity {

    private String id;
    private String nome;

}