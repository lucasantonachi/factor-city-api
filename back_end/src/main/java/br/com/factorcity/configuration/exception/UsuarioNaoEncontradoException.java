package br.com.factorcity.configuration.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UsuarioNaoEncontradoException() {
        super("Usuário não econtrado");
    }
}
