package br.com.factorcity.entrypoint.controller;

import br.com.factorcity.core.usecase.VeiculoUseCase;
import br.com.factorcity.core.usecase.ViagemUseCase;
import br.com.factorcity.dataprovider.database.entity.VeiculoTable;
import br.com.factorcity.dataprovider.database.entity.ViagemTable;
import br.com.factorcity.entrypoint.model.request.VeiculoRequest;
import br.com.factorcity.entrypoint.model.request.ViagemRequest;
import br.com.factorcity.entrypoint.model.response.VeiculoResponse;
import br.com.factorcity.entrypoint.model.response.ViagemResponse;
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
@RequestMapping("/viagem")
public class ViagemController {

    @Resource(name = "ViagemUseCase")
    private ViagemUseCase viagemUseCase;

    @GetMapping
    public ResponseEntity<Page<VeiculoResponse>> getAll(@PageableDefault(sort = "idViagem", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        Page<ViagemResponse> list = this.viagemUseCase.getAll(paginacao);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViagemResponse> getById(@PathVariable Long id) {

        ViagemTable viagemTable = this.viagemUseCase.getById(id);
        return ResponseEntity.ok(new ViagemResponse(viagemTable));
    }

    @GetMapping("/search-by-veiculo/{idVeiculo}")
    public ResponseEntity<List<ViagemResponse>> getAllByUsuario(@PathVariable Long idVeiculo) {

        List<ViagemResponse> viagemResponses = this.viagemUseCase.getAllByVeiculo(idVeiculo);
        return new ResponseEntity(viagemResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ViagemResponse> createVeiculo(@RequestBody @Valid ViagemRequest viagemRequest, UriComponentsBuilder uriComponentsBuilder) {

        ViagemTable viagemTable = this.viagemUseCase.createViagem(viagemRequest);

        URI uri = uriComponentsBuilder.path("/viagem/{idViagem}")
                .buildAndExpand(viagemTable.getIdViagem()).toUri();
        return ResponseEntity.created(uri).body(new ViagemResponse(viagemTable));
    }
}
