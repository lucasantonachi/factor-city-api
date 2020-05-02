package br.com.factorcity.entrypoint.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PostoRequest {

    @NotNull
    @NotEmpty
    private String nomePosto;

    @NotNull
    @NotEmpty
    private String latitudePosto;

    @NotNull
    @NotEmpty
    private String longitudePosto;

    @NotNull
    private Integer avaliacaoPosto;

    @NotNull
    private BigDecimal precoGasolina;

    @NotNull
    private BigDecimal precoEtanol;

    @NotNull
    private BigDecimal precoDiesel;

    @NotNull
    private BigDecimal precoGas;

    public String getNomePosto() {
        return nomePosto;
    }

    public void setNomePosto(String nomePosto) {
        this.nomePosto = nomePosto;
    }

    public String getLatitudePosto() {
        return latitudePosto;
    }

    public void setLatitudePosto(String latitudePosto) {
        this.latitudePosto = latitudePosto;
    }

    public String getLongitudePosto() {
        return longitudePosto;
    }

    public void setLongitudePosto(String longitudePosto) {
        this.longitudePosto = longitudePosto;
    }

    public Integer getAvaliacaoPosto() {
        return avaliacaoPosto;
    }

    public void setAvaliacaoPosto(Integer avaliacaoPosto) {
        this.avaliacaoPosto = avaliacaoPosto;
    }

    public BigDecimal getPrecoGasolina() {
        return precoGasolina;
    }

    public void setPrecoGasolina(BigDecimal precoGasolina) {
        this.precoGasolina = precoGasolina;
    }

    public BigDecimal getPrecoEtanol() {
        return precoEtanol;
    }

    public void setPrecoEtanol(BigDecimal precoEtanol) {
        this.precoEtanol = precoEtanol;
    }

    public BigDecimal getPrecoDiesel() {
        return precoDiesel;
    }

    public void setPrecoDiesel(BigDecimal precoDiesel) {
        this.precoDiesel = precoDiesel;
    }

    public BigDecimal getPrecoGas() {
        return precoGas;
    }

    public void setPrecoGas(BigDecimal precoGas) {
        this.precoGas = precoGas;
    }
}
