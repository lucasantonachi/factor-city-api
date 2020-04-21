package br.com.factorcity.core.usecase;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("SenhaUseCase")
public class SenhaUseCase {

    public String gerarSenhaCriptorgradada(String senha){
        BCryptPasswordEncoder s = new BCryptPasswordEncoder();
        String senhaGerada = s.encode(senha);
        return senhaGerada;
    }
}
