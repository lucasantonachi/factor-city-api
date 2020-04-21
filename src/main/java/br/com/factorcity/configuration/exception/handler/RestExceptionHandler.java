package br.com.factorcity.configuration.exception.handler;

import br.com.factorcity.configuration.exception.*;
import br.com.factorcity.entrypoint.model.response.ErroApiResponse;
import br.com.factorcity.entrypoint.model.response.ErroFormularioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

//TODO: implementar Log4J
@RestControllerAdvice
public class RestExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErroApiResponse handleThrowable(Throwable exception) {
        exception.printStackTrace();
        return new ErroApiResponse("Erro inesperado! Favor acionar os responsáveis do sistema");
    }

    @ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ErroApiResponse handleMissingServletRequestParameterException(MissingServletRequestParameterException exception) {
        exception.printStackTrace();
        return new ErroApiResponse("Parâmetro de busca '" + exception.getParameterName() + "' perdido");
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroFormularioResponse> handle(MethodArgumentNotValidException exception) {
        exception.printStackTrace();
        List<ErroFormularioResponse> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroFormularioResponse erro = new ErroFormularioResponse(e.getField(), mensagem);
            dto.add(erro);
        });
        return dto;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CombustivelInvalidoException.class)
    public ErroApiResponse handleCombustivelInvalidoException(CombustivelInvalidoException exception) {
        exception.printStackTrace();
        return new ErroApiResponse(exception.getMessage());
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ErroApiResponse handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException exception) {
        exception.printStackTrace();
        return new ErroApiResponse(exception.getMessage());
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(VeiculoNaoEncontradoException.class)
    public ErroApiResponse handleVeiculoNaoEncontradoException(VeiculoNaoEncontradoException exception) {
        exception.printStackTrace();
        return new ErroApiResponse(exception.getMessage());
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ViagemNaoEncontradaException.class)
    public ErroApiResponse handleViagemNaoEncontradaException(ViagemNaoEncontradaException exception) {
        exception.printStackTrace();
        return new ErroApiResponse(exception.getMessage());
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(PostoNaoEncontradoException.class)
    public ErroApiResponse handlePostoNaoEncontradoException(PostoNaoEncontradoException exception) {
        exception.printStackTrace();
        return new ErroApiResponse(exception.getMessage());
    }

}
