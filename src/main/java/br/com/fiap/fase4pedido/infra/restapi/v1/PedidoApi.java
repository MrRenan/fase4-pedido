package br.com.fiap.fase4pedido.infra.restapi.v1;

import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoRequest;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

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

    @Operation(summary = "Pagar pedido. Quando esse endpoint é chamado, " +
            "é criada uma requisição via rabbitmq para iniciar entrega")
    @PutMapping("/{id}/pagar")
    @ResponseStatus(OK)
    PedidoResponse pagarPedido(@PathVariable String id);

    @Operation(summary = "Cancelar pedido.")
    @PutMapping("/{id}/cancelar")
    @ResponseStatus(OK)
    PedidoResponse cancelarPedido(@PathVariable String id);

    @Operation(summary = "Excluir pedido.")
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    void excluirPedido(@PathVariable String id);

    @Operation(summary = "Obter pedido por ID.")
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    PedidoResponse obterPedidoPorId(@PathVariable("id") String id);
}