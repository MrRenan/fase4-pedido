package br.com.fiap.fase4pedido.features.domain.service;

import br.com.fiap.fase4pedido.features.adapter.out.PedidoAdapter;
import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PedidoService {

    private final PedidoAdapter adapter;

    public Pedido criarPedido(Pedido pedido) {
        return adapter.criarPedido(pedido);
    }
}
