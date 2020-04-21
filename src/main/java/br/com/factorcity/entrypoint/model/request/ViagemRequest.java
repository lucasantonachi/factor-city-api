package br.com.factorcity.entrypoint.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ViagemRequest {

    @NotNull
    @NotEmpty
    private String latitudeOrigemViagem;

    @NotNull
    @NotEmpty
    private String longitudeOrigemViagem;

    @NotNull
    @NotEmpty
    private String latitudeDestinoViagem;

    @NotNull
    @NotEmpty
    private String longitudeDestinoViagem;

    @NotNull
    private BigDecimal distanciaViagem;

    @NotNull
    private Integer duracaoViagem;

    @NotNull
    private Long idVeiculo;

    @NotNull
    private Long idPosto;

    public String getLatitudeOrigemViagem() {
        return latitudeOrigemViagem;
    }

    public void setLatitudeOrigemViagem(String latitudeOrigemViagem) {
        this.latitudeOrigemViagem = latitudeOrigemViagem;
    }

    public String getLongitudeOrigemViagem() {
        return longitudeOrigemViagem;
    }

    public void setLongitudeOrigemViagem(String longitudeOrigemViagem) {
        this.longitudeOrigemViagem = longitudeOrigemViagem;
    }

    public String getLatitudeDestinoViagem() {
        return latitudeDestinoViagem;
    }

    public void setLatitudeDestinoViagem(String latitudeDestinoViagem) {
        this.latitudeDestinoViagem = latitudeDestinoViagem;
    }

    public String getLongitudeDestinoViagem() {
        return longitudeDestinoViagem;
    }

    public void setLongitudeDestinoViagem(String longitudeDestinoViagem) {
        this.longitudeDestinoViagem = longitudeDestinoViagem;
    }

    public BigDecimal getDistanciaViagem() {
        return distanciaViagem;
    }

    public void setDistanciaViagem(BigDecimal distanciaViagem) {
        this.distanciaViagem = distanciaViagem;
    }

    public Integer getDuracaoViagem() {
        return duracaoViagem;
    }

    public void setDuracaoViagem(Integer duracaoViagem) {
        this.duracaoViagem = duracaoViagem;
    }

    public Long getVeiculoTable() {
        return idVeiculo;
    }

    public void setVeiculoTable(Long veiculoTable) {
        this.idVeiculo = veiculoTable;
    }

    public Long getPostoTable() {
        return idPosto;
    }

    public void setPostoTable(Long postoTable) {
        this.idPosto = postoTable;
    }
}
