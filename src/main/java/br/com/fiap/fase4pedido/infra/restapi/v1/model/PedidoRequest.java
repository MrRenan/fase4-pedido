package br.com.fiap.fase4pedido.infra.restapi.v1.model;

import lombok.Builder;

import java.util.List;

@Builder
public record PedidoRequest(
        String clienteId,
        List<ProdutoRequest> produtos
) {
    public record ProdutoRequest (
            String id,
            int quantidade
    ){

    }
}
