package com.bootcamp.demo.bc_forum.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.demo.bc_forum.codelib.GResponse;

// 全局攔截
@RestControllerAdvice
public class GlobalExceptionHandler {

  // ! 專業攔截 NumberFormatException
  // @ExceptionHandler(value = NumberFormatException.class)
  // public String handleNumberFormatException(NumberFormatException e) {
  //   return "I got issue, please help. Reason=" + e.getMessage();
  // }
  @ExceptionHandler(value = NumberFormatException.class)
  public GResponse<ErrorMessage> handleNumberFormatException(NumberFormatException e) {
    ErrorMessage errorMessage = ErrorMessage.builder() //
      .code(999) //
      .message("I got issue, please help. " + e.getMessage()) //
      .build();
    return GResponse.<ErrorMessage>builder() //
      .code(999)
      .message("System Error.")
      .data(errorMessage)
      .build();
  }
}
