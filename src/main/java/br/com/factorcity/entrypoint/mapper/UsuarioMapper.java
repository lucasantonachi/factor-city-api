package br.com.factorcity.entrypoint.mapper;

import br.com.factorcity.dataprovider.database.entity.UsuarioTable;
import br.com.factorcity.dataprovider.database.entity.VeiculoTable;
import br.com.factorcity.entrypoint.model.request.UsuarioRequest;
import br.com.factorcity.entrypoint.model.request.VeiculoRequest;

public class UsuarioMapper {

    public static UsuarioTable requestToTable(UsuarioRequest usuarioRequest){
        UsuarioTable usuarioTable = new UsuarioTable(usuarioRequest.getEmail(), usuarioRequest.getNome(), usuarioRequest.getIdade());
        return usuarioTable;
    }
}
