package br.com.fiap.fase4pedido.features.domain.exception.exception;

public class ProdutoNaoEncontradoException extends RuntimeException {
    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}
