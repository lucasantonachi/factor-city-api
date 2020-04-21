package br.com.factorcity.entrypoint.model.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class TokenResponse {

    private String tipo;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;

    public TokenResponse(String token, String tipo, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.tipo = tipo;
        this.authorities = authorities;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
