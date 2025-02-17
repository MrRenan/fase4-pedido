package br.com.fiap.fase4pedido.features.adapter.in.v1;

import br.com.fiap.fase4pedido.features.adapter.in.v1.mapper.PedidoMapper;
import br.com.fiap.fase4pedido.features.application.usecase.PedidoUseCase;
import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.infra.restapi.v1.PedidoApi;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoRequest;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PedidoController implements PedidoApi {

    private final PedidoMapper mapper;
    private final PedidoUseCase useCase;

    @Override
    public PedidoResponse criarPedido(PedidoRequest pedidoRequest) {
        Pedido pedido = useCase.criarPedido(mapper.paraPedido(pedidoRequest));
        return mapper.paraPedidoResponse(pedido);
    }
}
