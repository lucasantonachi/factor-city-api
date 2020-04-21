package br.com.factorcity.configuration.exception;

public class VeiculoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public VeiculoNaoEncontradoException() {
        super("Veículo não econtrado");
    }
}
