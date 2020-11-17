package br.com.factorcity.entrypoint.model.request;

import javax.validation.constraints.NotNull;

public class AvaliacaoRequest {

    @NotNull
    private Long idUsuario;

    @NotNull
    private Long idPosto;

    @NotNull
//    @Size(min = 11, max = 11)
    private Integer pontuacao;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
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
