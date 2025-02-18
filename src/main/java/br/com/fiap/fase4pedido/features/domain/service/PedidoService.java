package br.com.fiap.fase4pedido.features.domain.service;

import br.com.fiap.fase4pedido.features.adapter.out.PedidoAdapter;
import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.features.domain.entity.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoAdapter adapter;

    public Pedido criarPedido(Pedido pedido) {
        return adapter.criarPedido(pedido);
    }

    public List<Pedido> obterPedidos() {
        return adapter.obterPedidos();
    }

    public Pedido obterPedidoPorId(String id) {
        return adapter.obterPedidoPorId(id);
    }

    public Pedido atualizarPedido(Pedido pedido) {
        return adapter.atualizarPedido(pedido);
    }

    public Pedido pagarPedido(String id) {
        Pedido pedido = obterPedidoPorId(id);
        pedido.setStatus(Status.PAGO);
        return atualizarPedido(pedido);
    }

    public Pedido cancelarPedido(String id) {
        Pedido pedido = obterPedidoPorId(id);
        pedido.setStatus(Status.CANCELADO);
        return atualizarPedido(pedido);
    }
}
