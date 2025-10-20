package com.bootcamp.demo.bc_forum.codelib;

import com.bootcamp.demo.bc_forum.exception.ErrorMessage;

public class GResponse<T> {
  private Integer code;
  private String message;
  private T data;

  public Integer getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  public static <T> Builder<T> builder() {
    return new Builder<>();
  }

  public GResponse(Builder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static class Builder<T> {
    private Integer code;
    private String message;
    private T data;

    public Builder<T> code(Integer code) {
      this.code = code;
      return this;
    }

    public Builder<T> message(String message) {
      this.message = message;
      return this;
    }

    public Builder<T> data(T data) {
      this.data = data;
      return this;
    }

    public GResponse<T> build() {
      return new GResponse<>(this);
    }
  }

  public static void main(String[] args) {
    GResponse<ErrorMessage> response = GResponse.<ErrorMessage>builder() //
        .code(999) //
        .message("Testing") //
        .data(new ErrorMessage(999, "ABCDE"))
        .build();

    System.out.println(response.getCode());
    System.out.println(response.getMessage());
    System.out.println(response.getData());
  }
}
