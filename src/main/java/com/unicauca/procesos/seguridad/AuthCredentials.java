package com.unicauca.procesos.seguridad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthCredentials {
    private String correo;
    private String password;
}
