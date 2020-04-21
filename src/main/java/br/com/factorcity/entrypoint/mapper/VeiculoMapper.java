package br.com.factorcity.entrypoint.mapper;

import br.com.factorcity.dataprovider.database.entity.VeiculoTable;
import br.com.factorcity.entrypoint.model.request.VeiculoRequest;

public class VeiculoMapper {

    public static VeiculoTable requestToTable(VeiculoRequest veiculoRequest){
        VeiculoTable veiculoTable = new VeiculoTable(veiculoRequest.getMarcaVeiculo(), veiculoRequest.getModeloVeiculo(), veiculoRequest.getConsumoVeiculo());
        return veiculoTable;
    }
}
