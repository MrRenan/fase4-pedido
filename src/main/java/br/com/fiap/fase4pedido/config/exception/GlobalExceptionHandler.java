package br.com.fiap.fase4pedido.config.exception;



import br.com.fiap.fase4pedido.features.domain.exception.exception.ClienteNaoEncontradoException;
import br.com.fiap.fase4pedido.features.domain.exception.exception.PedidoNaoEncontradoException;
import br.com.fiap.fase4pedido.features.domain.exception.exception.ProdutoNaoEncontradoException;
import br.com.fiap.fase4pedido.features.domain.exception.exception.dto.SimpleError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<SimpleError> handleClienteNaoEncontradoException(ClienteNaoEncontradoException ex) {
        return ResponseEntity.status(NOT_FOUND).body(new SimpleError(ex.getMessage(), NOT_FOUND.toString()));
    }

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    public ResponseEntity<SimpleError> handlePedidoNaoEncontradoException(PedidoNaoEncontradoException ex) {
        return ResponseEntity.status(NOT_FOUND).body(new SimpleError(ex.getMessage(), NOT_FOUND.toString()));
    }

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<SimpleError> handleProdutoNaoEncontradoException(ProdutoNaoEncontradoException ex) {
        return ResponseEntity.status(NOT_FOUND).body(new SimpleError(ex.getMessage(), NOT_FOUND.toString()));
    }

}
