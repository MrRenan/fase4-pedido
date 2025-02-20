package br.com.fiap.fase4pedido.infra.restapi.v1;

import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoRequest;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/v1/pedido")
public interface PedidoApi {

    @PostMapping
    @ResponseStatus(CREATED)
    PedidoResponse criarPedido(@RequestBody PedidoRequest pedidoRequest);

    @GetMapping
    @ResponseStatus(OK)
    List<PedidoResponse> obterPedidos();

    @PutMapping("/{id}/pagar")
    @ResponseStatus(OK)
    PedidoResponse pagarPedido(@PathVariable String id);

    @PutMapping("/{id}/cancelar")
    @ResponseStatus(OK)
    PedidoResponse cancelarPedido(@PathVariable String id);

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    PedidoResponse obterPedidoPorId(@PathVariable("id") String id);
}