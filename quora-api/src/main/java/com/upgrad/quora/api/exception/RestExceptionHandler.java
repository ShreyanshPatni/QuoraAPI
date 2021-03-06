package com.upgrad.quora.api.exception;

import com.upgrad.quora.api.model.ErrorResponse;
import com.upgrad.quora.service.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

    //Exception handler for SignUpRestrictedException
    @ExceptionHandler(SignUpRestrictedException.class)
    public ResponseEntity<ErrorResponse> signupRestrictedException(SignUpRestrictedException sre, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
            new ErrorResponse().code(sre.getCode()).message(sre.getErrorMessage()), HttpStatus.CONFLICT
        );
    }

    //Exception handler for AuthenticationFailedException
    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<ErrorResponse> authenticationFailedException(AuthenticationFailedException afe, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(afe.getCode()).message(afe.getErrorMessage()), HttpStatus.UNAUTHORIZED
        );
    }

    //Exception handler for SignOutRestrictedException
    @ExceptionHandler(SignOutRestrictedException.class)
    public ResponseEntity<ErrorResponse> signOutRestrictedException(SignOutRestrictedException sre, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(sre.getCode()).message(sre.getErrorMessage()), HttpStatus.UNAUTHORIZED
        );
    }

    //Exception handler for AuthorizationFailedException
    @ExceptionHandler(AuthorizationFailedException.class)
    public ResponseEntity<ErrorResponse> authorizationFailedException(AuthorizationFailedException afe, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(afe.getCode()).message(afe.getErrorMessage()), HttpStatus.FORBIDDEN
        );
    }

    //Exception handler for UserNotFoundException
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundException(UserNotFoundException une, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(une.getCode()).message(une.getErrorMessage()), HttpStatus.NOT_FOUND
        );
    }

    //Exception handler for InvalidQuestionException
    @ExceptionHandler(InvalidQuestionException.class) //QuestionException
    public ResponseEntity<ErrorResponse> invalidQuestionException(InvalidQuestionException iqe, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(iqe.getCode()).message(iqe.getErrorMessage()), HttpStatus.BAD_REQUEST
        );
    }

    //Exception handler for AnswerNotFoundException
    @ExceptionHandler(AnswerNotFoundException.class)
    public ResponseEntity<ErrorResponse> answerNotFoundException(AnswerNotFoundException ane, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(ane.getCode()).message(ane.getErrorMessage()), HttpStatus.BAD_REQUEST
        );
    }
}
