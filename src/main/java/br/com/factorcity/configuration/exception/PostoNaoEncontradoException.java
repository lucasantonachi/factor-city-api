package br.com.factorcity.configuration.exception;

public class PostoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PostoNaoEncontradoException() {
        super("Posto não econtrado");
    }
}
