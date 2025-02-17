package br.com.fiap.fase4pedido.infra.restapi.v1;

import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoRequest;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "Pedido", description = "Operações relacionadas ao dominio de pedido")
@RequestMapping("/v1/pedido")
public interface PedidoApi {

    @Operation(summary = "Criar pedido.")
    @PostMapping
    @ResponseStatus(CREATED)
    PedidoResponse criarPedido(@RequestBody PedidoRequest pedidoRequest);

}