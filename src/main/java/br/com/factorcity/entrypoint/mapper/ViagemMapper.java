package br.com.factorcity.entrypoint.mapper;

import br.com.factorcity.dataprovider.database.entity.ViagemTable;
import br.com.factorcity.entrypoint.model.request.ViagemRequest;


public class ViagemMapper {

    public static ViagemTable requestToTable(ViagemRequest viagemRequest){
        ViagemTable viagemTable = new ViagemTable(viagemRequest.getLatitudeOrigemViagem(), viagemRequest.getLongitudeOrigemViagem(),
                viagemRequest.getLatitudeDestinoViagem(),viagemRequest.getLongitudeDestinoViagem(), viagemRequest.getDistanciaViagem(),
                viagemRequest.getDuracaoViagem());

        return viagemTable;
    }
}
