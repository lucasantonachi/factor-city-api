package br.com.factorcity.dataprovider.database;

import br.com.factorcity.dataprovider.database.entity.AvaliacaoTable;
import br.com.factorcity.dataprovider.database.entity.keys.AvaliacaoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoTable, AvaliacaoId> {
}
