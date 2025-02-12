package br.com.fiap.fase4pedido.controllers;


import br.com.fiap.fase4pedido.dtos.PedidoRecordDTO;
import br.com.fiap.fase4pedido.model.PedidoModel;
import br.com.fiap.fase4pedido.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PedidoController {


        private final PedidoService pedidoService;

        public PedidoController(PedidoService pedidoService) {
            this.pedidoService = pedidoService;
        }

        @GetMapping("/pedidos")
        public ResponseEntity<List<PedidoModel>> getAllIdPedido() {
            return ResponseEntity.ok(this.pedidoService.getAll());
        }

}