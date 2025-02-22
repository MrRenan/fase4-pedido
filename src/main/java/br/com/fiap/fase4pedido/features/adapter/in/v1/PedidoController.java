package br.com.fiap.fase4pedido.features.adapter.in.v1;

import br.com.fiap.fase4pedido.features.adapter.in.v1.mapper.PedidoMapper;
import br.com.fiap.fase4pedido.features.application.usecase.PedidoUseCase;
import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.infra.restapi.v1.PedidoApi;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoRequest;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/pedido")
@RequiredArgsConstructor
public class PedidoController implements PedidoApi {

    private final PedidoMapper mapper;
    private final PedidoUseCase useCase;

    @Override
    public PedidoResponse criarPedido(@RequestBody PedidoRequest pedidoRequest) {
        Pedido pedido = useCase.criarPedido(mapper.paraPedido(pedidoRequest));
        return mapper.paraPedidoResponse(pedido);
    }

    @Override
    public List<PedidoResponse> obterPedidos() {
        List<Pedido> pedidos = useCase.obterPedidos();
        return pedidos.stream().map(mapper::paraPedidoResponse).collect(Collectors.toList());
    }

    @Override
    public PedidoResponse pagarPedido(@PathVariable String id) {
        Pedido pedido = useCase.pagarPedido(id);
        return mapper.paraPedidoResponse(pedido);
    }

    @Override
    public PedidoResponse cancelarPedido(@PathVariable String id) {
        Pedido pedido = useCase.cancelarPedido(id);
        return mapper.paraPedidoResponse(pedido);
    }

    @Override
    public void excluirPedido(String id) {
        useCase.excluirPedido(id);
    }

    @Override
    public PedidoResponse obterPedidoPorId(String id) {
        Pedido pedido = useCase.obterPedidoPorId(id);
        return mapper.paraPedidoResponse(pedido);
    }
}