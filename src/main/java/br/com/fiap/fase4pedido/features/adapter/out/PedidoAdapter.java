package br.com.fiap.fase4pedido.features.adapter.out;

import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.features.port.PedidoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.fiap.fase4pedido.features.domain.entity.Status.CRIADO;
import static java.time.LocalDate.now;

@Component
@RequiredArgsConstructor
public class PedidoAdapter implements PedidoPort {

    @Override
    public Pedido criarPedido(Pedido pedido) {
        Pedido novoPedido = new Pedido();
        novoPedido.setStatus(CRIADO);
        novoPedido.setDataCriacao(now());
        return novoPedido;
    }

}