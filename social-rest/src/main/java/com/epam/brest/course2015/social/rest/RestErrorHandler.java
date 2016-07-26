package com.epam.brest.course2015.social.rest;


import com.epam.brest.course2015.social.test.Logged;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by alexander on 12.11.15.
 */
@ControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @Logged
    public String handleDataAccessException(
                                DataAccessException ex) {
        return "DataAccessException: " + ex.getLocalizedMessage();
    }

}
