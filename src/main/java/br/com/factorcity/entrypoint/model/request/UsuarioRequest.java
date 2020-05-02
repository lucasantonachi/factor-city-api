package br.com.factorcity.entrypoint.model.request;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UsuarioRequest {

    @NotNull
    @NotEmpty
//    @Size(min = 11, max = 11)
    private String email;

    @NotNull
    @NotEmpty
//    @Size(min = 11, max = 11)
    private String nome;

    @NotNull
//    @Size(min = 11, max = 11)
    private Integer idade;

    @NotNull
    @NotEmpty
//    @Size(min = 5, max = 6)
    private String senha;

    @NotNull
    @NotEmpty
    private List<String> perfisUsuario;

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<String> getPerfisUsuario() {
        return perfisUsuario;
    }

    public void setPerfisUsuario(List<String> perfisUsuario) {
        this.perfisUsuario = perfisUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
