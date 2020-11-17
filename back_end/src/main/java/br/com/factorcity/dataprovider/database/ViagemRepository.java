package br.com.factorcity.dataprovider.database;

import br.com.factorcity.dataprovider.database.entity.VeiculoTable;
import br.com.factorcity.dataprovider.database.entity.ViagemTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViagemRepository extends JpaRepository<ViagemTable, Long> {

    public List<ViagemTable> findAllByVeiculoTable(VeiculoTable veiculo);
}
