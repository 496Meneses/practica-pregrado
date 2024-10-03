package com.unicauca.procesos.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PingResponse {

    private String date;
    private String message;
}
