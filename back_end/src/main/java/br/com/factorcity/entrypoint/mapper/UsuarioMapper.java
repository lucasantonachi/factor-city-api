package br.com.factorcity.entrypoint.mapper;

import br.com.factorcity.dataprovider.database.entity.UsuarioTable;
import br.com.factorcity.entrypoint.model.request.UsuarioRequest;
import br.com.factorcity.entrypoint.model.response.UsuarioResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static UsuarioTable requestToTable(UsuarioRequest usuarioRequest){
        UsuarioTable usuarioTable = new UsuarioTable(usuarioRequest.getEmail(), usuarioRequest.getNome(), usuarioRequest.getIdade());
        return usuarioTable;
    }

    public static UsuarioResponse tableToResponse(UsuarioTable usuarioTable){
        return new UsuarioResponse(usuarioTable.getIdUsuario(), usuarioTable.getEmailUsuario(), usuarioTable.getNomeUsuario(),
                usuarioTable.getIdadeUsuario(), usuarioTable.getFlagAtivoUsuario(), usuarioTable.getPerfisUsuario());
    }

    public static Page<UsuarioResponse> tablePageToResponsePage(Page<UsuarioTable> usuarioBean) {
        return usuarioBean.map(UsuarioResponse::new);
    }

    public static List<UsuarioResponse> tableListToResponseList(List<UsuarioTable> usuarioBean) {
        return usuarioBean.stream().map(UsuarioResponse::new).collect(Collectors.toList());
    }
}
