package br.com.factorcity.dataprovider.database.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
public class UsuarioTable implements UserDetails {

    @Id
    @SequenceGenerator(name = "usuario", sequenceName = "sq_tbl_usuario", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    @Column(name = "USU_ID_USUARIO")
    private Long idUsuario;

    @Column(name = "USU_DS_EMAIL")
    private String emailUsuario;

    @Column(name = "USU_DS_NOME")
    private String nomeUsuario;

    @Column(name = "USU_NR_IDADE")
    private Integer idadeUsuario;

    @Column(name = "USU_DS_SENHA")
    private String senhaUsuario;

    @Column(name = "USU_FL_ATIVO")
    private Integer flagAtivoUsuario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TB_USUARIO_PERFIL",
            joinColumns = { @JoinColumn(name = "FK_USUARIO") },
            inverseJoinColumns = { @JoinColumn(name = "FK_PERFIL")})
    private List<PerfilTable> perfisUsuario = new ArrayList<>();

    public UsuarioTable(String emailUsuario, String nomeUsuario, Integer idadeUsuario) {
        this.emailUsuario = emailUsuario;
        this.nomeUsuario = nomeUsuario;
        this.idadeUsuario = idadeUsuario;
    }

    public UsuarioTable() {
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Integer getIdadeUsuario() {
        return idadeUsuario;
    }

    public void setIdadeUsuario(Integer idadeUsuario) {
        this.idadeUsuario = idadeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public List<PerfilTable> getPerfisUsuario() {
        return perfisUsuario;
    }

    public void setPerfisUsuario(List<PerfilTable> perfisUsuario) {
        this.perfisUsuario = perfisUsuario;
    }

    public Integer getFlagAtivoUsuario() {
        return flagAtivoUsuario;
    }

    public void setFlagAtivoUsuario(Integer flagAtivoUsuario) {
        this.flagAtivoUsuario = flagAtivoUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfisUsuario;
    }

    @Override
    public String getPassword() {
        return this.senhaUsuario;
    }

    @Override
    public String getUsername() {
        return this.emailUsuario;
    }

    //@Transient metodo para verificar se user está inativo pelo atributo flag

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
