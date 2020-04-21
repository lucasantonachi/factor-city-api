package br.com.factorcity.dataprovider.database.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_VIAGEM")
public class ViagemTable {

    @Id
    @SequenceGenerator(name = "viagem", sequenceName = "sq_tbl_viagem", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "viagem")
    @Column(name = "VIA_ID_VIAGEM")
    private Long idViagem;

    @Column(name = "VIA_LT_ORIGEM")
    private String latitudeOrigemViagem;

    @Column(name = "VIA_LG_ORIGEM")
    private String longitudeOrigemViagem;

    @Column(name = "VIA_LT_DESTINO")
    private String latitudeDestinoViagem;

    @Column(name = "VIA_LG_DESTINO")
    private String longitudeDestinoViagem;

    @Column(name = "VIA_NR_DISTANCIA")
    private BigDecimal distanciaViagem;

    @Column(name = "VIA_TP_DURACAO")
    private Integer duracaoViagem;

    @ManyToOne
    @JoinColumn(name = "FK_VEICULO")
    private VeiculoTable veiculoTable;

    @ManyToOne
    @JoinColumn(name = "FK_POSTO")
    private PostoTable postoTable;

    public ViagemTable(String latitudeOrigemViagem, String longitudeOrigemViagem, String latitudeDestinoViagem, String longitudeDestinoViagem, BigDecimal distanciaViagem, Integer duracaoViagem) {
        this.latitudeOrigemViagem = latitudeOrigemViagem;
        this.longitudeOrigemViagem = longitudeOrigemViagem;
        this.latitudeDestinoViagem = latitudeDestinoViagem;
        this.longitudeDestinoViagem = longitudeDestinoViagem;
        this.distanciaViagem = distanciaViagem;
        this.duracaoViagem = duracaoViagem;
    }

    public ViagemTable() {
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

    public VeiculoTable getVeiculoTable() {
        return veiculoTable;
    }

    public void setVeiculoTable(VeiculoTable veiculoTable) {
        this.veiculoTable = veiculoTable;
    }

    public PostoTable getPostoTable() {
        return postoTable;
    }

    public void setPostoTable(PostoTable postoTable) {
        this.postoTable = postoTable;
    }
}
