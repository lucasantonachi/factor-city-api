package br.com.factorcity.core.usecase;

import br.com.factorcity.dataprovider.database.PerfilRepository;
import br.com.factorcity.dataprovider.database.entity.PerfilTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PerfilUseCase")
public class PerfilUseCase {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<PerfilTable> popularPerfis(List<String> listaOrigem) {
        List<PerfilTable> perfilNovo = new ArrayList<>();

        listaOrigem.forEach(perfil -> {
            if (this.perfilRepository.existsByNomePerfil(perfil)) {
                perfilNovo.add(this.perfilRepository.findByNomePerfil(perfil));
            }
        });

        return perfilNovo;
    }
}
