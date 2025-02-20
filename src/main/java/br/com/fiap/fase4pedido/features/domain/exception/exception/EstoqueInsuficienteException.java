package br.com.fiap.fase4pedido.features.domain.exception.exception;

public class EstoqueInsuficienteException extends RuntimeException {
    public EstoqueInsuficienteException(String mensagem) {
        super(mensagem);
    }

}
