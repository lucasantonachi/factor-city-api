package br.com.factorcity.entrypoint.model.response;

public class ErroFormularioResponse {

    private String campo;
    private String mensagem;

    public ErroFormularioResponse(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return mensagem;
    }

}
