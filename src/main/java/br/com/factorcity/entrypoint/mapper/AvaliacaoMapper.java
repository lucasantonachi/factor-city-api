package br.com.factorcity.entrypoint.mapper;

import br.com.factorcity.dataprovider.database.entity.AvaliacaoTable;
import br.com.factorcity.entrypoint.model.request.AvaliacaoRequest;
import br.com.factorcity.entrypoint.model.response.AvaliacaoResponse;
import org.springframework.data.domain.Page;

public class AvaliacaoMapper {

    public static AvaliacaoTable requestToTable(AvaliacaoRequest avaliacaoRequest){
        AvaliacaoTable avaliacaoTable = new AvaliacaoTable(avaliacaoRequest.getIdUsuario(), avaliacaoRequest.getIdPosto(),
                avaliacaoRequest.getPontuacao());
        return avaliacaoTable;
    }

    public static Page<AvaliacaoResponse> tablePageToResponsePage(Page<AvaliacaoTable> avaliacaoTables) {
        return avaliacaoTables.map(AvaliacaoResponse::new);
    }
}
