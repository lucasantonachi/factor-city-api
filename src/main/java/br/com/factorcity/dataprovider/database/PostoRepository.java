package br.com.factorcity.dataprovider.database;

import br.com.factorcity.dataprovider.database.entity.PostoTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostoRepository extends JpaRepository<PostoTable, Long> {

}
