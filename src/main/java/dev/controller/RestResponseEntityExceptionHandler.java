package dev.controller;

import dev.exception.ItemNotFoundException;
<<<<<<< HEAD
import org.springframework.dao.InvalidDataAccessApiUsageException;
=======
>>>>>>> gestion de l'exception DataIntegrityViolation
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ItemNotFoundException.class })
    protected ResponseEntity<Object> handleConflict(ItemNotFoundException ex, WebRequest request) {
        String bodyOfResponse = "L'objet recherché n'existe pas";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { JpaObjectRetrievalFailureException.class })
    protected ResponseEntity<Object> handleConflict(JpaObjectRetrievalFailureException ex, WebRequest request) {
        String bodyOfResponse = "Impossible de supprimer le(s) élément(s) demandé(s). Celui(ceux)-ci est(sont) peut-être déjà supprimé(s).";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { InvalidDataAccessApiUsageException.class })
    protected ResponseEntity<Object> handleConflict(InvalidDataAccessApiUsageException ex, WebRequest request) {
        String bodyOfResponse = "Impossible de supprimer le(s) élément(s) demandé(s). Celui(ceux)-ci n'a(ont) peut-être pas encore été créé(s).";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    protected ResponseEntity<Object> handleConflict(DataIntegrityViolationException ex, WebRequest request) {
        String bodyOfResponse = "Suppression interdite";
        return   handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
