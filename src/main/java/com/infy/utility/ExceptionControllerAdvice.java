package com.infy.utility;

import com.infy.exception.InfyBankException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @Autowired
    Environment environment;
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception){
        ErrorInfo error = new ErrorInfo();
        error.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InfyBankException.class)
    public ResponseEntity<ErrorInfo> infyBankExceptionHandler(InfyBankException exception){
        ErrorInfo error = new ErrorInfo();
        error.setErrorMessage(environment.getProperty(exception.getMessage()));
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(LocalDateTime.now());

        return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInfo> exceptionHandler(MethodArgumentNotValidException exception){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());

        String errorMsg = exception.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
                .collect(Collectors.joining(", "));
        errorInfo.setErrorMessage(errorMsg);
        errorInfo.setTimeStamp(LocalDateTime.now());

        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}
