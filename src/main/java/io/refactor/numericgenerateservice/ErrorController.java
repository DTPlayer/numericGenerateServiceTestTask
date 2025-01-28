package io.refactor.numericgenerateservice;

import io.refactor.numericgenerateservice.models.BaseModel;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public BaseModel exception(Exception ex) {
        return new BaseModel(ex.getMessage(), 500);
    }

}
