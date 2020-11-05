package br.com.factorcity.entrypoint.model.request;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class VeiculoRequest {

    @NotNull
    @NotEmpty
    private String marcaVeiculo;

    @NotNull
    @NotEmpty
    private String modeloVeiculo;

    @NotNull
    @NotEmpty
    private String tipoCombustivel;

    @NotNull
    private BigDecimal consumoVeiculo;

    @NotNull
    private Long idUsuario;

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

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public BigDecimal getConsumoVeiculo() {
        return consumoVeiculo;
    }

    public void setConsumoVeiculo(BigDecimal consumoVeiculo) {
        this.consumoVeiculo = consumoVeiculo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
