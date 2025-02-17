package br.com.fiap.fase4pedido.features.port;

import br.com.fiap.fase4pedido.features.domain.entity.Pedido;

import java.util.List;

public interface PedidoPort {

    Pedido criarPedido(Pedido pedido);

    List<Pedido> obterPedidos();
}