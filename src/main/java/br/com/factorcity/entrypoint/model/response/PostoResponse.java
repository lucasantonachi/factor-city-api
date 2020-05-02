package br.com.factorcity.entrypoint.model.response;

import br.com.factorcity.dataprovider.database.entity.PostoTable;

import java.math.BigDecimal;

public class PostoResponse {

    private Long idPosto;
    private String nomePosto;
    private String latitudePosto;
    private String longitudePosto;
    private Integer avaliacaoPosto;
    private BigDecimal precoGasolina;
    private BigDecimal precoEtanol;
    private BigDecimal precoDiesel;
    private BigDecimal precoGas;

    public PostoResponse(PostoTable postoTable){
        this.idPosto = postoTable.getIdPosto();
        this.nomePosto = postoTable.getNomePosto();
        this.latitudePosto = postoTable.getLatitudePosto();
        this.longitudePosto = postoTable.getLongitudePosto();
        this.avaliacaoPosto = postoTable.getAvaliacaoPosto();
        this.precoGasolina = postoTable.getPrecoGasolina();
        this.precoEtanol = postoTable.getPrecoEtanol();
        this.precoDiesel = postoTable.getPrecoDiesel();
        this.precoGas = postoTable.getPrecoGas();
    }

    public PostoResponse(Long idPosto, String nomePosto, String latitudePosto, String longitudePosto, Integer avaliacaoPosto,
                         BigDecimal precoGasolina, BigDecimal precoEtanol, BigDecimal precoDiesel, BigDecimal precoGas) {
        this.idPosto = idPosto;
        this.nomePosto = nomePosto;
        this.latitudePosto = latitudePosto;
        this.longitudePosto = longitudePosto;
        this.avaliacaoPosto = avaliacaoPosto;
        this.precoGasolina = precoGasolina;
        this.precoEtanol = precoEtanol;
        this.precoDiesel = precoDiesel;
        this.precoGas = precoGas;
    }

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

    public Long getIdPosto() {
        return idPosto;
    }

    public void setIdPosto(Long idPosto) {
        this.idPosto = idPosto;
    }
}
