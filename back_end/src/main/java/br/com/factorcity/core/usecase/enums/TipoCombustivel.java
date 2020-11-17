package br.com.factorcity.core.usecase.enums;

public enum TipoCombustivel {

    GASOLINA("GASOLINA"),
    ETANOL("ETANOL"),
    DIESEL("DIESEL"),
    GAS("GAS");

    private String descricao;

    TipoCombustivel(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
