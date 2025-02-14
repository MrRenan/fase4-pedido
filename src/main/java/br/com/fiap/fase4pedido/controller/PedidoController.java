package br.com.fiap.fase4pedido.controller;

import br.com.fiap.fase4pedido.dto.PedidoDto;
import br.com.fiap.fase4pedido.service.PedidoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/pedidos")

public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping()
    public List<PedidoDto> listarTodos() {
        return pedidoService.obterTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> listarPorId(@PathVariable @NotNull Long id) {
        PedidoDto dto = pedidoService.obterPorId(id);

        return  ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<PedidoDto> realizaPedido(@RequestBody @Valid PedidoDto dto, UriComponentsBuilder uriBuilder) {
        PedidoDto pedidoRealizado = pedidoService.criarPedido(dto);

        URI endereco = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedidoRealizado.getId()).toUri();

        return ResponseEntity.created(endereco).body(pedidoRealizado);

    }




    @PutMapping("/{id}/pago")
    public ResponseEntity<Void> aprovaPagamento(@PathVariable @NotNull Long id) {
        pedidoService.aprovaPagamentoPedido(id);

        return ResponseEntity.ok().build();

    }

}
