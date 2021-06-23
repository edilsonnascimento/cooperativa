package br.desafio.cooperativa.validacion;

import br.desafio.cooperativa.dto.ErroValidacaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroValidacaoDto> handler(MethodArgumentNotValidException exception){

        List<ErroValidacaoDto> erroValidacaoDtos = new ArrayList<>();

        exception.getFieldErrors().forEach( e ->
                {
                    String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
                    ErroValidacaoDto erroValidacaoDto = new ErroValidacaoDto(e.getField(), mensagem);
                    erroValidacaoDtos.add(erroValidacaoDto);
                }
        );
        return erroValidacaoDtos;
    }
}
