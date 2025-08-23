package com.example.Student.Managent.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorRespone {
  private int statusCode;
  private String message;

  public ErrorRespone(String message) {
    super();
    this.message = message;
  }


}
