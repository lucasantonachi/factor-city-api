package br.com.factorcity.core.usecase;

import br.com.factorcity.configuration.exception.PostoNaoEncontradoException;
import br.com.factorcity.dataprovider.database.PostoRepository;
import br.com.factorcity.dataprovider.database.entity.PostoTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("PostoUseCase")
public class PostoUseCase {

    @Autowired
    private PostoRepository postoRepository;

    public PostoTable getById(Long id) {

        Optional<PostoTable> postoTable = postoRepository.findById(id);
        if(postoTable.isPresent()){
            return postoTable.get();
        }else{
            throw new PostoNaoEncontradoException();
        }
    }
}
