package com.airbnbserver.exceptions.errors;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private Date timestamp = new Date();
    private int status = 400;
    private String level = "error";
    private String message;
}
