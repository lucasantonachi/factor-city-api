package br.com.factorcity.core.usecase;

import br.com.factorcity.configuration.exception.UsuarioNaoEncontradoException;
import br.com.factorcity.dataprovider.database.UsuarioRepository;
import br.com.factorcity.dataprovider.database.entity.UsuarioTable;
import br.com.factorcity.entrypoint.mapper.UsuarioMapper;
import br.com.factorcity.entrypoint.model.response.UsuarioResponse;
import br.com.factorcity.entrypoint.model.request.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service("UsuarioUserCase")
public class UsuarioUseCase {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Resource(name = "PerfilUseCase")
    private PerfilUseCase perfilUseCase;

    @Resource(name = "SenhaUseCase")
    private SenhaUseCase senhaUseCase;

    public Page<UsuarioResponse> getAll(Pageable paginacao){

        Page<UsuarioTable> usuarioModel = usuarioRepository.findAll(paginacao);
        return UsuarioResponse.converter(usuarioModel);
    }

    public UsuarioTable getById(Long id) {

        Optional<UsuarioTable> usuarioModel = usuarioRepository.findById(id);

        if(usuarioModel.isPresent()){
            return usuarioModel.get();
        }else{
         throw new UsuarioNaoEncontradoException();
        }
    }

    public Page<UsuarioResponse> getByEmail(Pageable paginacao, String param) {

        if(usuarioRepository.existsByEmailUsuarioLikeIgnoreCase(param + "%")){
            Page<UsuarioTable> individuoAbordadoModel =  usuarioRepository.findAllByEmailUsuarioLikeIgnoreCase(paginacao,param + "%");
            return UsuarioResponse.converter(individuoAbordadoModel);
        } else{
            throw new UsuarioNaoEncontradoException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UsuarioTable createUser(UsuarioRequest usuarioForm) {

        UsuarioTable usuarioModel = UsuarioMapper.requestToTable(usuarioForm);
        usuarioModel.setFlagAtivoUsuario(1);
        usuarioModel.setSenhaUsuario(senhaUseCase.gerarSenhaCriptorgradada(usuarioForm.getSenha()));
        usuarioModel.setPerfisUsuario(this.perfilUseCase.popularPerfis(usuarioForm.getPerfisUsuario()));
        usuarioRepository.save(usuarioModel);
        return usuarioModel;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UsuarioTable updateUser(Long id, UsuarioRequest usuarioFORM) {

        if(existById(id)){
            UsuarioTable usuarioBean = usuarioFORM.atualizar(id, usuarioRepository);
            usuarioBean.setSenhaUsuario(senhaUseCase.gerarSenhaCriptorgradada(usuarioFORM.getSenha()));
            usuarioBean.setPerfisUsuario(this.perfilUseCase.popularPerfis(usuarioFORM.getPerfisUsuario()));
            return usuarioBean;
        }else {
            throw new UsuarioNaoEncontradoException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UsuarioTable inactivateUser(Long id) {

        if(existById(id)){
        UsuarioTable usuarioBean = usuarioRepository.getOne(id);
        usuarioBean.setFlagAtivoUsuario(0);
        usuarioRepository.save(usuarioBean);
        return usuarioBean;
        }else {
            throw new UsuarioNaoEncontradoException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UsuarioTable activateUser(Long id) {

        if(existById(id)){
        UsuarioTable usuarioBean = usuarioRepository.getOne(id);
        usuarioBean.setFlagAtivoUsuario(1);
        usuarioRepository.save(usuarioBean);
        return usuarioBean;
        } else {
            throw new UsuarioNaoEncontradoException();
        }
    }

    public boolean existByEmail(UsuarioRequest usuarioFORM) {
        UsuarioTable usuarioModel = UsuarioMapper.requestToTable(usuarioFORM);
        if (usuarioRepository.existsByEmailUsuario(usuarioModel.getEmailUsuario())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existById(Long id) {
        if (usuarioRepository.existsByIdUsuario(id)) {
            return true;
        } else {
            return false;
        }
    }

}
