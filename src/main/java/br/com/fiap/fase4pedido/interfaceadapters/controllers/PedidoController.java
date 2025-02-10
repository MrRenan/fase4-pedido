package br.com.fiap.fase4pedido.interfaceadapters.controllers;

import br.com.fiap.fase4pedido.application.usecases.CriarPedidoUseCase;
import br.com.fiap.fase4pedido.application.usecases.ObterPedidoUseCase;
import br.com.fiap.fase4pedido.domain.entities.PedidoEntity;
import br.com.fiap.fase4pedido.interfaceadapters.dtos.PedidoRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private CriarPedidoUseCase criarPedidoUseCase;

    @Autowired
    private ObterPedidoUseCase obterPedidoUseCase;

    @PostMapping
    public ResponseEntity<PedidoEntity> criar(@RequestBody PedidoRecordDTO pedidoRecordDTO) {
        try {
            PedidoEntity pedidoEntity = criarPedidoUseCase.executar(pedidoRecordDTO);
            return new ResponseEntity<>(pedidoEntity, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Ou outro código de erro adequado
        }
    }

        @GetMapping("/{id}")
        public ResponseEntity<PedidoEntity> obter(@PathVariable Long id){
            PedidoEntity pedidoEntity = obterPedidoUseCase.executar(id);
            if (pedidoEntity != null) {
                return new ResponseEntity<>(pedidoEntity, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

    }

