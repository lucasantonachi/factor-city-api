package br.com.factorcity.entrypoint.mapper;

import br.com.factorcity.entrypoint.model.request.LoginRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginMapper {

    public static UsernamePasswordAuthenticationToken requestToUsernamePasswordAuthenticationToken(LoginRequest loginRequest) {
        return new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getSenha());
    }
}
