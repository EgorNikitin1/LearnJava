package ru.muctr.Task12.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerErrorException;

import java.rmi.ServerError;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
        ServerErrorException err = new ServerErrorException(HttpStatus.NOT_FOUND.toString(), e);
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleInvalidDataException(InvalidDataException e) {
        ServerErrorException err = new ServerErrorException(HttpStatus.BAD_REQUEST.toString(), e);
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
