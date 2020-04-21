package br.com.factorcity.core.service;

import br.com.factorcity.dataprovider.database.UsuarioRepository;
import br.com.factorcity.dataprovider.database.entity.UsuarioTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioTable> usuario = usuarioRepository.findByEmailUsuario(username);
        if(usuario.isPresent()){
            return usuario.get();
        }

        throw new UsernameNotFoundException("Dados inválidos");
    }
}
