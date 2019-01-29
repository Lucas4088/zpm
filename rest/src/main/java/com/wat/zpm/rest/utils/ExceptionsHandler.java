package com.wat.zpm.rest.utils;

import com.wat.model.exception.ElementNotFoundException;
import com.wat.model.exception.OperationForbiddenException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedList;
import java.util.List;

@ControllerAdvice
public class ExceptionsHandler {

    private final MessageSource messageSource;

    public ExceptionsHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validationException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return new ResponseEntity<>(processFieldErrors(fieldErrors), HttpStatus.BAD_REQUEST);
    }

    private List<String> processFieldErrors(List<FieldError> fieldErrors) {
        List<String> errors = new LinkedList<>();

        for (FieldError fieldError : fieldErrors) {
            //String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
            errors.add(fieldError.getField() + ", " + fieldError.getDefaultMessage());
        }

        return errors;
    }

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<Object> elementNotFoundExceptionHandler(ElementNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OperationForbiddenException.class)
    public ResponseEntity<Object> operationForbiddenExceptionHandler(OperationForbiddenException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    /*private String resolveLocalizedErrorMessage(FieldError fieldError) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String localizedErrorMessage = messageSource.getMessage(fieldError.getDefaultMessage(),null, currentLocale);

        if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
            String[] fieldErrorCodes = fieldError.getCodes();
            localizedErrorMessage = fieldErrorCodes[0];
        }
        return localizedErrorMessage;
    }*/

}
