package br.com.factorcity.dataprovider.database.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_POSTO")
public class PostoTable {

    @Id
    @SequenceGenerator(name = "posto", sequenceName = "sq_tbl_posto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posto")
    @Column(name = "PT_ID_POSTO")
    private Long idPosto;

    @Column(name = "PT_DS_NOME")
    private String nomePosto;

    @Column(name = "PT_LT_POSTO")
    private String latitudePosto;

    @Column(name = "PT_LG_POSTO")
    private String longitudePosto;

    @Column(name = "PT_NR_AVALIACAO")
    private Integer avaliacaoPosto;

    @Column(name = "PT_PR_GASOLINA")
    private BigDecimal precoGasolina;

    @Column(name = "PT_PR_ETANOL")
    private BigDecimal precoEtanol;

    @Column(name = "PT_PR_DIESEL")
    private BigDecimal precoDiesel;

    @Column(name = "PT_PR_GAS")
    private BigDecimal precoGas;

    public PostoTable(String nomePosto, String latitudePosto, String longitudePosto, Integer avaliacaoPosto, BigDecimal precoGasolina,
                      BigDecimal precoEtanol, BigDecimal precoDiesel, BigDecimal precoGas) {
        this.latitudePosto = latitudePosto;
        this.longitudePosto = longitudePosto;
        this.avaliacaoPosto = avaliacaoPosto;
        this.precoGasolina = precoGasolina;
        this.precoEtanol = precoEtanol;
        this.precoDiesel = precoDiesel;
        this.precoGas = precoGas;
        this.nomePosto = nomePosto;
    }

    public PostoTable() {
    }

    public Long getIdPosto() {
        return idPosto;
    }

    public void setIdPosto(Long idPosto) {
        this.idPosto = idPosto;
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

    public String getNomePosto() {
        return nomePosto;
    }

    public void setNomePosto(String nomePosto) {
        this.nomePosto = nomePosto;
    }
}
