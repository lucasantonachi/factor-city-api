package br.com.factorcity.core.usecase;

import br.com.factorcity.configuration.exception.CombustivelInvalidoException;
import br.com.factorcity.configuration.exception.PostoNaoEncontradoException;
import br.com.factorcity.dataprovider.database.PostoRepository;
import br.com.factorcity.dataprovider.database.entity.PostoTable;
import br.com.factorcity.entrypoint.mapper.PostoMapper;
import br.com.factorcity.entrypoint.model.request.PostoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("PostoUseCase")
public class PostoUseCase {

    @Autowired
    private PostoRepository postoRepository;

    public Page<PostoTable> getAll(Pageable paginacao){

        Page<PostoTable> postoTables = postoRepository.findAll(paginacao);
        return postoTables;
    }

    public PostoTable getById(Long id) {

        Optional<PostoTable> postoTable = postoRepository.findById(id);
        if(postoTable.isPresent()){
            return postoTable.get();
        }else{
            throw new PostoNaoEncontradoException();
        }
    }

    public Page<PostoTable> getByNome(Pageable paginacao, String param) {

        if(postoRepository.existsByNomePostoLikeIgnoreCase(param + "%")){
            Page<PostoTable> postoTables =  postoRepository.findAllByNomePostoLikeIgnoreCase(paginacao,param + "%");
            return postoTables;
        } else{
            throw new PostoNaoEncontradoException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public PostoTable createPosto(PostoRequest postoRequest) {

        try {
            //  TODO: criar lógica para validar se já existe
            PostoTable postoTable = PostoMapper.requestToTable(postoRequest);
            postoRepository.save(postoTable);
            return postoTable;

        } catch (IllegalArgumentException e) {
            throw new CombustivelInvalidoException();
        }
    }
}
