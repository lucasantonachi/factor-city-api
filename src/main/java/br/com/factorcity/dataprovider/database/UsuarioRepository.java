package br.com.factorcity.dataprovider.database;

import br.com.factorcity.dataprovider.database.entity.UsuarioTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioTable, Long> {

    public Optional<UsuarioTable> findByEmailUsuario(String cpf);

    public Page<UsuarioTable> findAllByEmailUsuarioLikeIgnoreCase(Pageable pageable, String cpf);

    public boolean existsByEmailUsuarioLikeIgnoreCase(String cpf);

    public boolean existsByEmailUsuario(String cpf);

    public boolean existsByIdUsuario(Long id);

}
