package br.com.factorcity.entrypoint.model.response;

import br.com.factorcity.core.usecase.enums.TipoCombustivel;
import br.com.factorcity.dataprovider.database.entity.UsuarioTable;
import br.com.factorcity.dataprovider.database.entity.VeiculoTable;

import java.math.BigDecimal;

public class VeiculoResponse {

    private Long idVeiculo;
    private String marcaVeiculo;
    private String modeloVeiculo;
    private TipoCombustivel tipoCombustivel;
    private BigDecimal consumoVeiculo;
    private UsuarioTable usuarioTable;

    public VeiculoResponse(VeiculoTable veiculoTable){
        this.idVeiculo = veiculoTable.getIdVeiculo();
        this.marcaVeiculo = veiculoTable.getMarcaVeiculo();
        this.modeloVeiculo = veiculoTable.getModeloVeiculo();
        this.tipoCombustivel = veiculoTable.getTipoCombustivel();
        this.consumoVeiculo = veiculoTable.getConsumoVeiculo();
        this.usuarioTable = veiculoTable.getUsuarioTable();
    }

    public VeiculoResponse(Long idVeiculo, String marcaVeiculo, String modeloVeiculo, TipoCombustivel tipoCombustivel,
                           BigDecimal consumoVeiculo, UsuarioTable usuarioTable) {
        this.idVeiculo = idVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.tipoCombustivel = tipoCombustivel;
        this.consumoVeiculo = consumoVeiculo;
        this.usuarioTable = usuarioTable;
    }

    public VeiculoResponse() {

    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public BigDecimal getConsumoVeiculo() {
        return consumoVeiculo;
    }

    public void setConsumoVeiculo(BigDecimal consumoVeiculo) {
        this.consumoVeiculo = consumoVeiculo;
    }

    public Long getUsuarioTable() {
        return usuarioTable.getIdUsuario();
    }

    public void setUsuarioTable(UsuarioTable usuarioTable) {
        this.usuarioTable = usuarioTable;
    }


}
