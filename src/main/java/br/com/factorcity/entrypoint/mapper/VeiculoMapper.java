package br.com.factorcity.entrypoint.mapper;

import br.com.factorcity.dataprovider.database.entity.VeiculoTable;
import br.com.factorcity.entrypoint.model.request.VeiculoRequest;
import br.com.factorcity.entrypoint.model.response.VeiculoResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class VeiculoMapper {

    public static VeiculoTable requestToTable(VeiculoRequest veiculoRequest){
        VeiculoTable veiculoTable = new VeiculoTable(veiculoRequest.getMarcaVeiculo(), veiculoRequest.getModeloVeiculo(), veiculoRequest.getConsumoVeiculo());
        return veiculoTable;
    }

    public static VeiculoResponse tableToResponse(VeiculoTable veiculoTable){
        return new VeiculoResponse(veiculoTable.getIdVeiculo(), veiculoTable.getMarcaVeiculo(), veiculoTable.getModeloVeiculo(),
                veiculoTable.getTipoCombustivel(), veiculoTable.getConsumoVeiculo(), veiculoTable.getUsuarioTable());
    }

    public static Page<VeiculoResponse> tablePageToResponsePage(Page<VeiculoTable> veiculoTable) {
        return veiculoTable.map(VeiculoResponse::new);
    }

    public static List<VeiculoResponse> tableListToResponseList(List<VeiculoTable> veiculoTables) {
        return veiculoTables.stream().map(VeiculoResponse::new).collect(Collectors.toList());
    }
}
