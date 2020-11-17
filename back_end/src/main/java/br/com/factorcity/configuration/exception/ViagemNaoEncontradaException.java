package br.com.factorcity.configuration.exception;

public class ViagemNaoEncontradaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ViagemNaoEncontradaException() {
        super("Viagem não econtrada");
    }
}
