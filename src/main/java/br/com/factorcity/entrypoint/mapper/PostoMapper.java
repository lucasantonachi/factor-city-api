package br.com.factorcity.entrypoint.mapper;

import br.com.factorcity.dataprovider.database.entity.PostoTable;
import br.com.factorcity.entrypoint.model.request.PostoRequest;
import br.com.factorcity.entrypoint.model.response.PostoResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class PostoMapper {

    public static PostoTable requestToTable(PostoRequest postoRequest){
        return new PostoTable(postoRequest.getNomePosto(), postoRequest.getLatitudePosto(), postoRequest.getLongitudePosto(),
                postoRequest.getAvaliacaoPosto(), postoRequest.getPrecoGasolina(), postoRequest.getPrecoEtanol(),
                postoRequest.getPrecoDiesel(), postoRequest.getPrecoGas());
    }

    public static PostoResponse tableToResponse(PostoTable postoTable){
        return new PostoResponse(postoTable.getIdPosto(), postoTable.getNomePosto(), postoTable.getLatitudePosto(), postoTable.getLongitudePosto(),
                postoTable.getAvaliacaoPosto(), postoTable.getPrecoGasolina(), postoTable.getPrecoEtanol(),
                postoTable.getPrecoDiesel(), postoTable.getPrecoGas());
    }

    public static Page<PostoResponse> tablePageToResponsePage(Page<PostoTable> postoTables) {
        return postoTables.map(PostoResponse::new);
    }

    public static List<PostoResponse> tableListToResponseList(List<PostoTable> postoTables) {
        return postoTables.stream().map(PostoResponse::new).collect(Collectors.toList());
    }

}
