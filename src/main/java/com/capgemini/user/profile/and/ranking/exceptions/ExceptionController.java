package com.capgemini.user.profile.and.ranking.exceptions;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public void handleAccessDenied() {
        // display 403 site
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DataAccessException.class)
    public void handlePageNotFound() {
        // display 404 site
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProfileNotFoundException.class)
    public void handleProfileNotFound() {
        // display Profile Not found site
    }

}
