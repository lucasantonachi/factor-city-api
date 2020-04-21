package br.com.factorcity.entrypoint.model.response;

public class SucessoResponse {

    private String code;
    private String message;

    public SucessoResponse(String message) {
        this.message = message;
        this.code = "OK";
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
