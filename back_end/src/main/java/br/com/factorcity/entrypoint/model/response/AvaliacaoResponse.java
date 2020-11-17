package br.com.factorcity.entrypoint.model.response;

import br.com.factorcity.dataprovider.database.entity.AvaliacaoTable;

public class AvaliacaoResponse {

    private Long idUsuario;
    private Long idPosto;
    private Integer pontuacao;

    public AvaliacaoResponse(AvaliacaoTable avaliacaoTable) {
        this.idUsuario = avaliacaoTable.getIdUsuario();
        this.idPosto = avaliacaoTable.getIdPosto();
        this.pontuacao = avaliacaoTable.getPontuacao();
    }

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
