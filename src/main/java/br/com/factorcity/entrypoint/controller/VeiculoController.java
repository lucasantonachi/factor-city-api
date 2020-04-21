package br.com.factorcity.entrypoint.controller;

import br.com.factorcity.core.usecase.VeiculoUseCase;
import br.com.factorcity.dataprovider.database.entity.VeiculoTable;
import br.com.factorcity.entrypoint.model.request.VeiculoRequest;
import br.com.factorcity.entrypoint.model.response.VeiculoResponse;
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
import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Resource(name = "VeiculoUseCase")
    private VeiculoUseCase veiculoUseCase;

    @GetMapping
    public ResponseEntity<Page<VeiculoResponse>> getAll(@PageableDefault(sort = "idVeiculo", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        Page<VeiculoResponse> list = this.veiculoUseCase.getAll(paginacao);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponse> getById(@PathVariable Long id) {

        VeiculoTable veiculoTable = this.veiculoUseCase.getById(id);
        return ResponseEntity.ok(new VeiculoResponse(veiculoTable));
    }

    @GetMapping("/search-by-user/{idUser}")
    public ResponseEntity<List<VeiculoResponse>> getAllByUsuario(@PathVariable Long idUser) {

        List<VeiculoResponse> listVeiculos = this.veiculoUseCase.getAllByUsuario(idUser);
        return new ResponseEntity(listVeiculos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VeiculoResponse> createVeiculo(@RequestBody @Valid VeiculoRequest veiculoRequest, UriComponentsBuilder uriComponentsBuilder) {

        VeiculoTable veiculoTable = this.veiculoUseCase.createVeiculo(veiculoRequest);

        URI uri = uriComponentsBuilder.path("/veiculo/{idVeiculo}")
                    .buildAndExpand(veiculoTable.getIdVeiculo()).toUri();
        return ResponseEntity.created(uri).body(new VeiculoResponse(veiculoTable));
    }
}
