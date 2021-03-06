package br.com.factorcity.dataprovider.database.entity;

import br.com.factorcity.dataprovider.database.entity.keys.AvaliacaoId;

import javax.persistence.*;

@Entity
@Table(name = "TB_AVALIACAO")
@IdClass(AvaliacaoId.class)
public class AvaliacaoTable {

    @Id
    @Column(name = "USU_ID_USUARIO")
    private Long idUsuario;

    @Id
    @Column(name = "PT_ID_POSTO")
    private Long idPosto;

    @Column(name = "AV_NR_PONTUACAO")
    private Integer pontuacao;

    public AvaliacaoTable(Long idUsuario, Long idPosto, Integer pontuacao) {
        this.idUsuario = idUsuario;
        this.idPosto = idPosto;
        this.pontuacao = pontuacao;
    }

    public AvaliacaoTable() {
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsurio(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdPosto() {
        return idPosto;
    }

    public void setIdPosto(Long idPosto) {
        this.idPosto = idPosto;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }
}
