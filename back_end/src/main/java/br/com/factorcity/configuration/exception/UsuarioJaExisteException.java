package br.com.factorcity.configuration.exception;

public class UsuarioJaExisteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UsuarioJaExisteException() {
        super("Usuário já existe");
    }
}
