package br.com.factorcity.dataprovider.database;

import br.com.factorcity.dataprovider.database.entity.PerfilTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<PerfilTable, Long> {

    public PerfilTable findByNomePerfil(String nomePerfil);

    public boolean existsByNomePerfil(String perfil);
}
