package br.com.factorcity.core.usecase;

import br.com.factorcity.configuration.exception.CombustivelInvalidoException;
import br.com.factorcity.configuration.exception.VeiculoNaoEncontradoException;
import br.com.factorcity.core.usecase.enums.TipoCombustivel;
import br.com.factorcity.dataprovider.database.VeiculoRepository;
import br.com.factorcity.dataprovider.database.entity.UsuarioTable;
import br.com.factorcity.dataprovider.database.entity.VeiculoTable;
import br.com.factorcity.entrypoint.mapper.VeiculoMapper;
import br.com.factorcity.entrypoint.model.request.VeiculoRequest;
import br.com.factorcity.entrypoint.model.response.VeiculoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("VeiculoUseCase")
public class VeiculoUseCase {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Resource(name = "UsuarioUserCase")
    private UsuarioUseCase usuarioUseCase;

    public Page<VeiculoResponse> getAll(Pageable paginacao){

        Page<VeiculoTable> veiculoTable = veiculoRepository.findAll(paginacao);
        return VeiculoResponse.converter(veiculoTable);
    }

    public VeiculoTable getById(Long id) {

        Optional<VeiculoTable> veiculoTable = veiculoRepository.findById(id);
        if(veiculoTable.isPresent()){
            return veiculoTable.get();
        }else{
            throw new VeiculoNaoEncontradoException();
        }
    }

    public List<VeiculoResponse> getAllByUsuario(Long id) {

        UsuarioTable usuario = usuarioUseCase.getById(id);
        List<VeiculoTable> listVeiculos = veiculoRepository.findAllByUsuarioTable(usuario);
        return VeiculoResponse.converter(listVeiculos);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public VeiculoTable createVeiculo(VeiculoRequest veiculoRequest) {

        try {
            VeiculoTable veiculoTable = VeiculoMapper.requestToTable(veiculoRequest);
            veiculoTable.setTipoCombustivel(TipoCombustivel.valueOf(veiculoRequest.getTipoCombustivel()));
            veiculoTable.setUsuarioTable(usuarioUseCase.getById(veiculoRequest.getUsuarioTable()));
            veiculoRepository.save(veiculoTable);
            return veiculoTable;

        } catch (IllegalArgumentException e) {
            throw new CombustivelInvalidoException();
        }
    }

    public boolean existById(Long id) {
        if (veiculoRepository.existsByIdVeiculo(id)) {
            return true;
        } else {
            return false;
        }
    }
}
