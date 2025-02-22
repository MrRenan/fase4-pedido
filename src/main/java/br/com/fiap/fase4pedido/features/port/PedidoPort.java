package br.com.fiap.fase4pedido.features.port;

import br.com.fiap.fase4pedido.features.domain.entity.Pedido;

import java.util.List;

public interface PedidoPort {

    Pedido criarPedido(Pedido pedido);

    List<Pedido> obterPedidos();

    Pedido obterPedidoPorId(String id);

    Pedido atualizarPedido(Pedido pedido);

    Pedido pagarPedido(String id);

    void excluirPedido(String id);
}