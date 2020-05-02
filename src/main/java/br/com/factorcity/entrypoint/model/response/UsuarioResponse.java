package br.com.factorcity.entrypoint.model.response;

import br.com.factorcity.dataprovider.database.entity.PerfilTable;
import br.com.factorcity.dataprovider.database.entity.UsuarioTable;

import java.util.List;

public class UsuarioResponse {

    private Long id;
    private String email;
    private String nome;
    private Integer idade;
    private Integer flagAtivo;
    private List<PerfilTable> perfisUsuario;

    public UsuarioResponse(UsuarioTable usuarioModel) {
        this.id = usuarioModel.getIdUsuario();
        this.email = usuarioModel.getEmailUsuario();
        this.nome = usuarioModel.getNomeUsuario();
        this.idade = usuarioModel.getIdadeUsuario();
        this.flagAtivo = usuarioModel.getFlagAtivoUsuario();
        this.perfisUsuario = usuarioModel.getPerfisUsuario();
    }

    public UsuarioResponse(Long id, String email, String nome, Integer idade, Integer flagAtivo, List<PerfilTable> perfisUsuario) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.idade = idade;
        this.flagAtivo = flagAtivo;
        this.perfisUsuario = perfisUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(Integer flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public List<PerfilTable> getPerfisUsuario() {
        return perfisUsuario;
    }

    public void setPerfisUsuario(List<PerfilTable> perfisUsuario) {
        this.perfisUsuario = perfisUsuario;
    }

}
