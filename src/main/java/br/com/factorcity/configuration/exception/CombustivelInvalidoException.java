package br.com.factorcity.configuration.exception;

public class CombustivelInvalidoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CombustivelInvalidoException() {
        super("Tipo de combustível inválido");
    }
}
