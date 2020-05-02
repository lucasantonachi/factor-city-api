package br.com.factorcity.core.usecase;

import br.com.factorcity.configuration.exception.UsuarioJaExisteException;
import br.com.factorcity.configuration.exception.UsuarioNaoEncontradoException;
import br.com.factorcity.core.service.SenhaService;
import br.com.factorcity.dataprovider.database.UsuarioRepository;
import br.com.factorcity.dataprovider.database.entity.UsuarioTable;
import br.com.factorcity.entrypoint.mapper.UsuarioMapper;
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

    @Autowired
    private SenhaService senhaService;

    public Page<UsuarioTable> getAll(Pageable paginacao){

        Page<UsuarioTable> usuarioModel = usuarioRepository.findAll(paginacao);
        return usuarioModel;
    }

    public UsuarioTable getById(Long id) {

        Optional<UsuarioTable> usuarioModel = usuarioRepository.findById(id);

        if(usuarioModel.isPresent()){
            return usuarioModel.get();
        }else{
         throw new UsuarioNaoEncontradoException();
        }
    }

    public Page<UsuarioTable> getByEmail(Pageable paginacao, String param) {

        if(usuarioRepository.existsByEmailUsuarioLikeIgnoreCase(param + "%")){
            Page<UsuarioTable> individuoAbordadoModel =  usuarioRepository.findAllByEmailUsuarioLikeIgnoreCase(paginacao,param + "%");
            return individuoAbordadoModel;
        } else{
            throw new UsuarioNaoEncontradoException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UsuarioTable createUser(UsuarioRequest usuarioForm) {

        if(!existByEmail(usuarioForm.getEmail())){
            UsuarioTable usuarioModel = UsuarioMapper.requestToTable(usuarioForm);
            usuarioModel.setFlagAtivoUsuario(1);
            usuarioModel.setSenhaUsuario(senhaService.gerarSenhaCriptorgradada(usuarioForm.getSenha()));
            usuarioModel.setPerfisUsuario(this.perfilUseCase.popularPerfis(usuarioForm.getPerfisUsuario()));
            usuarioRepository.save(usuarioModel);
            return usuarioModel;
        }else{
            throw new UsuarioJaExisteException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UsuarioTable updateUser(Long id, UsuarioRequest usuarioFORM) {

        if(existById(id)){
            UsuarioTable usuarioBean = getById(id);
            usuarioBean.setEmailUsuario(usuarioFORM.getEmail());
            usuarioBean.setNomeUsuario(usuarioFORM.getNome());
            usuarioBean.setIdadeUsuario(usuarioFORM.getIdade());
            usuarioBean.setSenhaUsuario(senhaService.gerarSenhaCriptorgradada(usuarioFORM.getSenha()));
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

    public boolean existByEmail(String email) {
        if (usuarioRepository.existsByEmailUsuario(email)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existById(Long id) {
        if (usuarioRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

}
