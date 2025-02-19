package br.com.fiap.fase4pedido.infra.restapi.v1;

import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoRequest;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Tag(name = "Pedido", description = "Operações relacionadas ao dominio de pedido")
@RequestMapping("/v1/pedido")
public interface PedidoApi {

    @Operation(summary = "Criar pedido.")
    @PostMapping
    @ResponseStatus(CREATED)
    PedidoResponse criarPedido(@RequestBody PedidoRequest pedidoRequest);

    @Operation(summary = "Obter todos pedidos.")
    @GetMapping
    @ResponseStatus(OK)
    List<PedidoResponse> obterPedidos();

    @Operation(summary = "Pagar pedido.")
    @PutMapping("/{id}/pagar")
    @ResponseStatus(OK)
    PedidoResponse pagarPedido(@PathVariable String id);

    @Operation(summary = "Cancelar pedido.")
    @PutMapping("/{id}/cancelar")
    @ResponseStatus(OK)
    PedidoResponse cancelarPedido(@PathVariable String id);

    @Operation(summary = "Obter pedido por ID.")
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    PedidoResponse obterPedidoPorId(@PathVariable("id") String id);
}