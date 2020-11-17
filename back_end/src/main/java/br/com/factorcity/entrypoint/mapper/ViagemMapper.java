package br.com.factorcity.entrypoint.mapper;

import br.com.factorcity.dataprovider.database.entity.ViagemTable;
import br.com.factorcity.entrypoint.model.request.ViagemRequest;
import br.com.factorcity.entrypoint.model.response.ViagemResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;


public class ViagemMapper {

    public static ViagemTable requestToTable(ViagemRequest viagemRequest){
        ViagemTable viagemTable = new ViagemTable(viagemRequest.getLatitudeOrigemViagem(), viagemRequest.getLongitudeOrigemViagem(),
                viagemRequest.getLatitudeDestinoViagem(),viagemRequest.getLongitudeDestinoViagem(), viagemRequest.getDistanciaViagem(),
                viagemRequest.getDuracaoViagem());

        return viagemTable;
    }

    public static ViagemResponse tableToResponse(ViagemTable viagemTable){
        return new ViagemResponse(viagemTable.getIdViagem(), viagemTable.getLatitudeOrigemViagem(), viagemTable.getLongitudeOrigemViagem(),
                viagemTable.getLatitudeDestinoViagem(),viagemTable.getLongitudeDestinoViagem(),viagemTable.getDistanciaViagem(),
                viagemTable.getDuracaoViagem(),viagemTable.getVeiculoTable(),viagemTable.getPostoTable());
    }

    public static Page<ViagemResponse> tablePageToResponsePage(Page<ViagemTable> viagemTables) {
        return viagemTables.map(ViagemResponse::new);
    }

    public static List<ViagemResponse> tableListToResponseList(List<ViagemTable> veiculoTables) {
        return veiculoTables.stream().map(ViagemResponse::new).collect(Collectors.toList());
    }

}
