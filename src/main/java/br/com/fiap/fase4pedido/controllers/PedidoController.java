package br.com.fiap.fase4pedido.controllers;

import br.com.fiap.fase4pedido.model.Pedido;
import br.com.fiap.fase4pedido.dtos.PedidoRecordDTO;
import br.com.fiap.fase4pedido.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    final  PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> savePedido(@RequestBody @Valid PedidoRecordDTO pedidoRecordDTO) {
        var pedido = new Pedido();
        BeanUtils.copyProperties(pedidoRecordDTO, pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedido));
    }

}