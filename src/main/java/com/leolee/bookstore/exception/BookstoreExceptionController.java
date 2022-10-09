package com.leolee.bookstore.exception;

import org.hibernate.PropertyValueException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class BookstoreExceptionController {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity handleMissingParams(MissingServletRequestParameterException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getParameterName() + " parameter is missing!");
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity handleMissingProperties(PropertyValueException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getPropertyName() + " property is missing!");
    }

    @ExceptionHandler({EmptyResultDataAccessException.class, EntityNotFoundException.class})
    public ResponseEntity handleEmptyResult() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("The required entity is not exist from the database!");
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity handleNoSuchElement() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("The required entity is not exist from the database!");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity handleMethodNotSupported() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Request Method Not Supported!");
    }

}
