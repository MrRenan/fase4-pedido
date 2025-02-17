package br.com.fiap.fase4pedido.features.port;

import br.com.fiap.fase4pedido.features.domain.entity.Pedido;

public interface PedidoPort {

    Pedido criarPedido(Pedido pedido);

}