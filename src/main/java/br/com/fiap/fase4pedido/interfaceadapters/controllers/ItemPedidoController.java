package br.com.fiap.fase4pedido.interfaceadapters.controllers;

import br.com.fiap.fase4pedido.application.usecases.CriarItemPedidoUseCase;
import br.com.fiap.fase4pedido.domain.entities.ItemPedidoEntity;
import br.com.fiap.fase4pedido.interfaceadapters.dtos.ItemPedidoRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private CriarItemPedidoUseCase criarItemPedidoUseCase;

    @PostMapping
    public ResponseEntity<ItemPedidoEntity> criar(@RequestBody ItemPedidoRecordDTO itemPedidoDTO) {
        ItemPedidoEntity itemPedido = criarItemPedidoUseCase.executar(itemPedidoDTO);
        return new ResponseEntity<>(itemPedido, HttpStatus.CREATED);
    }
}
