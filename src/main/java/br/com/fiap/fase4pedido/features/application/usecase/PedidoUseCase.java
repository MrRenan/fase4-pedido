package br.com.fiap.fase4pedido.features.application.usecase;

import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.features.domain.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoUseCase {

    private final PedidoService service;
    public Pedido criarPedido(Pedido pedido) {
        return service.criarPedido(pedido);
    }

}