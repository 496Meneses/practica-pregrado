package com.unicauca.procesos.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {

    private Integer status;
    private String error;
    private String message;
}
