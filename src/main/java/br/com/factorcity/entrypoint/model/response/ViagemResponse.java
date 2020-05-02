package br.com.factorcity.entrypoint.model.response;

import br.com.factorcity.dataprovider.database.entity.PostoTable;
import br.com.factorcity.dataprovider.database.entity.VeiculoTable;
import br.com.factorcity.dataprovider.database.entity.ViagemTable;

import java.math.BigDecimal;

public class ViagemResponse {

    private Long idViagem;
    private String latitudeOrigemViagem;
    private String longitudeOrigemViagem;
    private String latitudeDestinoViagem;
    private String longitudeDestinoViagem;
    private BigDecimal distanciaViagem;
    private Integer duracaoViagem;
    private VeiculoTable veiculoTable;
    private PostoTable postoTable;

    public ViagemResponse(ViagemTable viagemTable) {
        this.idViagem = viagemTable.getIdViagem();
        this.latitudeOrigemViagem = viagemTable.getLatitudeOrigemViagem();
        this.longitudeOrigemViagem = viagemTable.getLongitudeOrigemViagem();
        this.latitudeDestinoViagem = viagemTable.getLatitudeDestinoViagem();
        this.longitudeDestinoViagem = viagemTable.getLongitudeDestinoViagem();
        this.distanciaViagem = viagemTable.getDistanciaViagem();
        this.duracaoViagem = viagemTable.getDuracaoViagem();
        this.veiculoTable = viagemTable.getVeiculoTable();
        this.postoTable = viagemTable.getPostoTable();
    }

    public ViagemResponse(Long idViagem, String latitudeOrigemViagem, String longitudeOrigemViagem, String latitudeDestinoViagem,
                          String longitudeDestinoViagem, BigDecimal distanciaViagem, Integer duracaoViagem, VeiculoTable veiculoTable,
                          PostoTable postoTable) {

        this.idViagem = idViagem;
        this.latitudeOrigemViagem = latitudeOrigemViagem;
        this.longitudeOrigemViagem = longitudeOrigemViagem;
        this.latitudeDestinoViagem = latitudeDestinoViagem;
        this.longitudeDestinoViagem = longitudeDestinoViagem;
        this.distanciaViagem = distanciaViagem;
        this.duracaoViagem = duracaoViagem;
        this.veiculoTable = veiculoTable;
        this.postoTable = postoTable;
    }

    public ViagemResponse() {
    }

    public Long getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(Long idViagem) {
        this.idViagem = idViagem;
    }

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
        return veiculoTable.getIdVeiculo();
    }

    public void setVeiculoTable(VeiculoTable veiculoTable) {
        this.veiculoTable = veiculoTable;
    }

    public Long getPostoTable() {
        return postoTable.getIdPosto();
    }

    public void setPostoTable(PostoTable postoTable) {
        this.postoTable = postoTable;
    }
}
