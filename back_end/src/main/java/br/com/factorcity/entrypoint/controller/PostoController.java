package br.com.factorcity.entrypoint.controller;

import br.com.factorcity.core.usecase.PostoUseCase;
import br.com.factorcity.dataprovider.database.entity.PostoTable;
import br.com.factorcity.entrypoint.mapper.PostoMapper;
import br.com.factorcity.entrypoint.model.request.PostoRequest;
import br.com.factorcity.entrypoint.model.response.PostoResponse;
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
@RequestMapping("/posto")
public class PostoController {

    @Resource(name = "PostoUseCase")
    private PostoUseCase postoUseCase;

    @GetMapping
    public ResponseEntity<Page<PostoResponse>> getAll(@PageableDefault(sort = "idPosto", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        Page<PostoTable> list = this.postoUseCase.getAll(paginacao);
        return new ResponseEntity(PostoMapper.tablePageToResponsePage(list), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostoResponse> getById(@PathVariable Long id) {

        PostoTable postoTable = this.postoUseCase.getById(id);
        return ResponseEntity.ok(PostoMapper.tableToResponse(postoTable));
    }

    @GetMapping("/nome")
    public ResponseEntity<Page<PostoResponse>> getByNome(@PageableDefault(sort = "idPosto", direction = Sort.Direction.ASC, page = 0, size = 20) Pageable paginacao, @RequestParam String sc) {

        Page<PostoTable> postoTables = postoUseCase.getByNome(paginacao, sc);
        return new ResponseEntity(PostoMapper.tablePageToResponsePage(postoTables), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostoResponse> createVeiculo(@RequestBody @Valid PostoRequest postoRequest, UriComponentsBuilder uriComponentsBuilder) {

        PostoTable postoTable = this.postoUseCase.createPosto(postoRequest);

        URI uri = uriComponentsBuilder.path("/veiculo/{idVeiculo}")
                .buildAndExpand(postoTable.getIdPosto()).toUri();
        return ResponseEntity.created(uri).body(PostoMapper.tableToResponse(postoTable));
    }
}
