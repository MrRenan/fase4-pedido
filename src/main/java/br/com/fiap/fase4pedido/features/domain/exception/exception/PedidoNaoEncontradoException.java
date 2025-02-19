package br.com.fiap.fase4pedido.features.domain.exception.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
    public PedidoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}
