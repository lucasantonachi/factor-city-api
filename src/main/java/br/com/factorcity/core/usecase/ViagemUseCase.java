package br.com.factorcity.core.usecase;

import br.com.factorcity.configuration.exception.CombustivelInvalidoException;
import br.com.factorcity.configuration.exception.ViagemNaoEncontradaException;
import br.com.factorcity.dataprovider.database.ViagemRepository;
import br.com.factorcity.dataprovider.database.entity.VeiculoTable;
import br.com.factorcity.dataprovider.database.entity.ViagemTable;
import br.com.factorcity.entrypoint.mapper.ViagemMapper;
import br.com.factorcity.entrypoint.model.request.ViagemRequest;
import br.com.factorcity.entrypoint.model.response.ViagemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("ViagemUseCase")
public class ViagemUseCase {

    @Autowired
    private ViagemRepository viagemRepository;

    @Resource(name = "VeiculoUseCase")
    private VeiculoUseCase veiculoUseCase;

    @Resource(name = "PostoUseCase")
    private PostoUseCase postoUseCase;

    public Page<ViagemResponse> getAll(Pageable paginacao){

        Page<ViagemTable> viagemResponses = viagemRepository.findAll(paginacao);
        return ViagemResponse.converter(viagemResponses);
    }

    public ViagemTable getById(Long id) {

        Optional<ViagemTable> viagemTable = viagemRepository.findById(id);
        if(viagemTable.isPresent()){
            return viagemTable.get();
        }else{
            throw new ViagemNaoEncontradaException();
        }
    }

    public List<ViagemResponse> getAllByVeiculo(Long id) {

        VeiculoTable veiculoTable = veiculoUseCase.getById(id);
        List<ViagemTable> listViagens = viagemRepository.findAllByVeiculoTable(veiculoTable);
        return ViagemResponse.converter(listViagens);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ViagemTable createViagem(ViagemRequest viagemRequest) {

        try {
            ViagemTable viagemTable = ViagemMapper.requestToTable(viagemRequest);
            viagemTable.setPostoTable(postoUseCase.getById(viagemRequest.getIdPosto()));
            viagemTable.setVeiculoTable(veiculoUseCase.getById(viagemRequest.getIdVeiculo()));
            viagemRepository.save(viagemTable);
            return viagemTable;

        } catch (IllegalArgumentException e) {
            throw new CombustivelInvalidoException();
        }
    }
}
