package tn.esprit.feresski.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NullPointerException.class)
  public Map<String, String> handleNullPointerException(NullPointerException exception) {
    Map<String, String> errorResponse = new HashMap<>();
    errorResponse.put("message", exception.getMessage());
    return errorResponse;
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  public Map<String, String> handleIllegalArgumentException(IllegalArgumentException exception) {
    Map<String, String> errorResponse = new HashMap<>();
    errorResponse.put("message", exception.getMessage());
    return errorResponse;
  }

}
