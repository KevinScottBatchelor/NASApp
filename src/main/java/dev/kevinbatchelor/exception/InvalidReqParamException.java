package dev.kevinbatchelor.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.BAD_REQUEST, reason = "You can only request from 1 to 5 photos. Please try again!")
public class InvalidReqParamException extends RuntimeException {
}