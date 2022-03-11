package com.test.hplus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

//@ControllerAdvice in this case handles advice of exception handling to all the controllers of the application
@ControllerAdvice
public class ApplicationExceptionHandler {

    /*
    This is a global exception.
    The exception handler in the login controller has been commented out so the exception can be directed to the global exception handler,
    but in case the exception wasn't commented out, the exception handler defined in the controller would take precedence.
    */
    @ExceptionHandler({ApplicationException.class, AsyncRequestTimeoutException.class})
    public String handleException() {
        System.out.println("in global exception handler");
        return "error";
    }

    //When an exception of type LoginFailureException type, then the handleLoginException will be called
    @ExceptionHandler(LoginFailureException.class)
    public ResponseEntity handleLoginFailure(LoginFailureException ex) {
        return  ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }
}
