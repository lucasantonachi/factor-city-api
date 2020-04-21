package br.com.factorcity.dataprovider.database.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_PERFILL")
public class PerfilTable implements GrantedAuthority {

    @Id
    @SequenceGenerator(name="perfil",sequenceName="sq_tbl_perfil",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="perfil")
    @Column(name = "PF_ID_PERFIL")
    private Long idPerfil;

    @NotBlank(message = "Nome é obrigatório")
    @Column(name = "PF_NM_PERFIL")
    private String nomePerfil;

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNomePerfil() {
        return nomePerfil;
    }

    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    @Override
    public String getAuthority() {
        return this.nomePerfil;
    }
}