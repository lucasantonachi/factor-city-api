package br.com.factorcity.dataprovider.database;

import br.com.factorcity.dataprovider.database.entity.UsuarioTable;
import br.com.factorcity.dataprovider.database.entity.VeiculoTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<VeiculoTable, Long> {

    public boolean existsByIdVeiculo(Long id);

    public List<VeiculoTable> findAllByUsuarioTable(UsuarioTable usuarioTable);
}
