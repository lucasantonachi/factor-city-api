package br.com.factorcity.dataprovider.database.entity;

import br.com.factorcity.core.usecase.enums.TipoCombustivel;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_VEICULO")
public class VeiculoTable {

    @Id
    @SequenceGenerator(name = "veiculo", sequenceName = "sq_tbl_veiculo", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo")
    @Column(name = "VEI_ID_VEICULO")
    private Long idVeiculo;

    @Column(name = "VEI_DS_MARCA")
    private String marcaVeiculo;

    @Column(name = "VEI_DS_MODELO")
    private String modeloVeiculo;

    @Column(name = "VEI_TP_COMBUSTIVEL")
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;

    @Column(name = "VEI_NR_CONSUMO")
    private BigDecimal consumoVeiculo;

    @ManyToOne
    @JoinColumn(name = "FK_USUARIO")
    private UsuarioTable usuarioTable;

    public VeiculoTable(){}

    public VeiculoTable(String marcaVeiculo, String modeloVeiculo, BigDecimal consumoVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.consumoVeiculo = consumoVeiculo;
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

    public void setConsumoVeiculo(BigDecimal consuoVeiculo) {
        this.consumoVeiculo = consuoVeiculo;
    }

    public UsuarioTable getUsuarioTable() {
        return usuarioTable;
    }

    public void setUsuarioTable(UsuarioTable usuarioTable) {
        this.usuarioTable = usuarioTable;
    }
}

