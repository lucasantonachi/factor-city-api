package br.com.factorcity.entrypoint.controller;

import br.com.factorcity.core.usecase.AvalicacaoUseCase;
import br.com.factorcity.dataprovider.database.entity.AvaliacaoTable;
import br.com.factorcity.entrypoint.mapper.AvaliacaoMapper;
import br.com.factorcity.entrypoint.model.request.AvaliacaoRequest;
import br.com.factorcity.entrypoint.model.response.SucessoResponse;
import br.com.factorcity.entrypoint.model.response.UsuarioResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Resource(name = "AvalicacaoUseCase")
    private AvalicacaoUseCase avalicacaoUseCase;

    @GetMapping
    public ResponseEntity<Page<UsuarioResponse>> getAll(@PageableDefault(sort = "idPosto", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        Page<AvaliacaoTable> list = this.avalicacaoUseCase.getAll(paginacao);
        return new ResponseEntity(AvaliacaoMapper.tablePageToResponsePage(list), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SucessoResponse> avaliar (@RequestBody @Valid AvaliacaoRequest avaliacaoRequest){
        avalicacaoUseCase.avaliar(avaliacaoRequest);
        return ResponseEntity.ok(new SucessoResponse("Avaliação cadastrada com sucesso!"));
    }
}
