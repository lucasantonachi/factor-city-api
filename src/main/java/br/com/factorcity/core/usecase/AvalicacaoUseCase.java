package br.com.factorcity.core.usecase;

import br.com.factorcity.configuration.exception.PostoNaoEncontradoException;
import br.com.factorcity.configuration.exception.UsuarioNaoEncontradoException;
import br.com.factorcity.dataprovider.database.AvaliacaoRepository;
import br.com.factorcity.dataprovider.database.entity.AvaliacaoTable;
import br.com.factorcity.entrypoint.mapper.AvaliacaoMapper;
import br.com.factorcity.entrypoint.model.request.AvaliacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("AvalicacaoUseCase")
public class AvalicacaoUseCase {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Resource(name = "UsuarioUserCase")
    private UsuarioUseCase usuarioUseCase;

    @Resource(name = "PostoUseCase")
    private PostoUseCase postoUseCase;

    public Page<AvaliacaoTable> getAll(Pageable paginacao){

        Page<AvaliacaoTable> avaliacaoTables = avaliacaoRepository.findAll(paginacao);
        return avaliacaoTables;
    }

    public void avaliar(AvaliacaoRequest avaliacaoRequest){
        if(!usuarioUseCase.existById(avaliacaoRequest.getIdUsuario())){
            throw new UsuarioNaoEncontradoException();
        } else if(!postoUseCase.existById(avaliacaoRequest.getIdPosto())){
            throw new PostoNaoEncontradoException();
        } else{
            AvaliacaoTable avaliacao = AvaliacaoMapper.requestToTable(avaliacaoRequest);
            avaliacaoRepository.save(avaliacao);
        }
    }
}
