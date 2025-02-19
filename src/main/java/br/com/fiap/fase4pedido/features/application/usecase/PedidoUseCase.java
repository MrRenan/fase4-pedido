package br.com.fiap.fase4pedido.features.application.usecase;

import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.features.domain.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoUseCase {

    private final PedidoService service;

    public Pedido criarPedido(Pedido pedido) {
        return service.criarPedido(pedido);
    }

    public List<Pedido> obterPedidos() {
        return service.obterPedidos();
    }

    public Pedido pagarPedido(String id) {
        return service.pagarPedido(id);
    }

    public Pedido cancelarPedido(String id) {
        return service.cancelarPedido(id);
    }

    public Pedido obterPedidoPorId(String id) {
        return service.obterPedidoPorId(id);
    }
}
