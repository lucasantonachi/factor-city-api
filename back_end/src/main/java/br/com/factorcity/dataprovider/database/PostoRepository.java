package br.com.factorcity.dataprovider.database;

import br.com.factorcity.dataprovider.database.entity.PostoTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostoRepository extends JpaRepository<PostoTable, Long> {

    public Page<PostoTable> findAllByNomePostoLikeIgnoreCase(Pageable pageable, String nome);

    public boolean existsByNomePostoLikeIgnoreCase(String nome);

}
