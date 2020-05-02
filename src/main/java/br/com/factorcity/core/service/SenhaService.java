package br.com.factorcity.core.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SenhaService {

    public String gerarSenhaCriptorgradada(String senha){
        BCryptPasswordEncoder s = new BCryptPasswordEncoder();
        String senhaGerada = s.encode(senha);
        return senhaGerada;
    }
}
