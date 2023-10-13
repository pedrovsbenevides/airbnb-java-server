package com.airbnbserver.exceptions.handlers;

import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.airbnbserver.exceptions.BusinessException;
import com.airbnbserver.exceptions.errors.ErrorResponse;

import jakarta.annotation.Resource;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Resource
    private MessageSource messageSource;

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }

    private ErrorResponse responseError(String message, HttpStatus statusCode, String level) {
        ErrorResponse responseError = new ErrorResponse();

        responseError.setMessage(message);
        responseError.setStatus(statusCode.value());
        responseError.setLevel(level);

        return responseError;

    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleGlobalException(Exception exception, WebRequest request) {
        if (exception.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {
            UndeclaredThrowableException undeclaredException = (UndeclaredThrowableException) exception;

            return this.handleBusinessException((BusinessException) undeclaredException.getUndeclaredThrowable(), request);
        } else {
            String message = this.getMessageSource().getMessage("server.error", new Object[] { exception.getMessage() }, null);

            ErrorResponse error = this.responseError(message, HttpStatus.INTERNAL_SERVER_ERROR, "error");

            return handleExceptionInternal(exception, error, this.headers(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }

    @ExceptionHandler({ BusinessException.class })
    private ResponseEntity<Object> handleBusinessException(BusinessException exception, WebRequest request) {
        ErrorResponse error = this.responseError(exception.getMessage(), HttpStatus.CONFLICT, "error");

        return handleExceptionInternal(exception, error, this.headers(), HttpStatus.CONFLICT, request);
    }
}