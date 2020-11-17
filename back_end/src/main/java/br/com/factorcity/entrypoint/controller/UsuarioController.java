package br.com.factorcity.entrypoint.controller;

import br.com.factorcity.core.usecase.UsuarioUseCase;
import br.com.factorcity.dataprovider.database.entity.UsuarioTable;
import br.com.factorcity.entrypoint.mapper.UsuarioMapper;
import br.com.factorcity.entrypoint.model.response.ErroApiResponse;
import br.com.factorcity.entrypoint.model.response.SucessoResponse;
import br.com.factorcity.entrypoint.model.response.UsuarioResponse;
import br.com.factorcity.entrypoint.model.request.UsuarioRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Resource(name = "UsuarioUserCase")
    private UsuarioUseCase usuarioUseCase;

    @GetMapping
    public ResponseEntity<Page<UsuarioResponse>> getAll(@PageableDefault(sort = "idUsuario", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        Page<UsuarioTable> list = this.usuarioUseCase.getAll(paginacao);
        return new ResponseEntity(UsuarioMapper.tablePageToResponsePage(list), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getById(@PathVariable Long id) {

        UsuarioTable usuario = this.usuarioUseCase.getById(id);
        return ResponseEntity.ok(UsuarioMapper.tableToResponse(usuario));
    }

    @GetMapping("/email")
    public ResponseEntity<Page<UsuarioResponse>> getByEmail(@PageableDefault(sort = "idUsuario", direction = Sort.Direction.ASC, page = 0, size = 20) Pageable paginacao, @RequestParam String sc) {

        Page<UsuarioTable> individuo = usuarioUseCase.getByEmail(paginacao, sc);
        return new ResponseEntity(UsuarioMapper.tablePageToResponsePage(individuo), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> createUser(@RequestBody @Valid UsuarioRequest usuarioFORM, UriComponentsBuilder uriComponentsBuilder) {

        UsuarioTable usuarioBean = this.usuarioUseCase.createUser(usuarioFORM);

        URI uri = uriComponentsBuilder.path("/usuario/{idUsuario}")
                .buildAndExpand(usuarioBean.getIdUsuario()).toUri();
        return ResponseEntity.created(uri).body(UsuarioMapper.tableToResponse(usuarioBean));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioRequest usuarioFORM) {

        UsuarioTable usuarioAtualizado = this.usuarioUseCase.updateUser(id, usuarioFORM);
        return ResponseEntity.ok(UsuarioMapper.tableToResponse(usuarioAtualizado));
    }

    @PutMapping("/ativar/{id}")
    public ResponseEntity<SucessoResponse> ativarUsuario(@PathVariable Long id) {

        this.usuarioUseCase.activateUser(id);
        return ResponseEntity.ok(new SucessoResponse("Usuário ativado com sucesso"));
    }

    @PutMapping("/inativar/{id}")
    public ResponseEntity<SucessoResponse> inativarUsuario(@PathVariable Long id) {

        this.usuarioUseCase.inactivateUser(id);
        return ResponseEntity.ok(new SucessoResponse("Usuário inativado com sucesso"));
    }
}
