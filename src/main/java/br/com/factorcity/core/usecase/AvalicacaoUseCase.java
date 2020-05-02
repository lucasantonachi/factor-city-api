package br.com.factorcity.core.usecase;

import br.com.factorcity.dataprovider.database.AvaliacaoRepository;
import br.com.factorcity.dataprovider.database.entity.AvaliacaoTable;
import br.com.factorcity.dataprovider.database.entity.PostoTable;
import br.com.factorcity.entrypoint.mapper.AvaliacaoMapper;
import br.com.factorcity.entrypoint.model.request.AvaliacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("AvalicacaoUseCase")
public class AvalicacaoUseCase {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Page<AvaliacaoTable> getAll(Pageable paginacao){

        Page<AvaliacaoTable> avaliacaoTables = avaliacaoRepository.findAll(paginacao);
        return avaliacaoTables;
    }

    public void avaliar(AvaliacaoRequest avaliacaoRequest){

        //TODO: validar se usuário e posto existe
        AvaliacaoTable avaliacao = AvaliacaoMapper.requestToTable(avaliacaoRequest);
        avaliacaoRepository.save(avaliacao);
    }
}
