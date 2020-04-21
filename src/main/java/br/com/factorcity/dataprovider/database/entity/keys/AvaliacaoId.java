package br.com.factorcity.dataprovider.database.entity.keys;

import java.io.Serializable;
import java.util.Objects;

public class AvaliacaoId implements Serializable {

    private Long idUsuario;
    private Long idPosto;

    public AvaliacaoId(Long idUsuario, Long idPosto) {
        this.idUsuario = idUsuario;
        this.idPosto = idPosto;
    }

    public AvaliacaoId() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoId that = (AvaliacaoId) o;
        return Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(idPosto, that.idPosto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idPosto);
    }
}
