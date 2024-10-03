package com.unicauca.procesos.common;


public final class Constants {
    private Constants() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    //SWAGGER
    public static final String SWAGGER_TITLE = "API Procesos autoevaluación Backend";
    public static final String SWAGGER_DESCRIPTION = "Servicios REST para el proyecto de Procesos de autoevaluación de la Universidad del Cauca";
    public static final String SWAGGER_VERSION = "v0.0.1";

    //GENERAL
    public static final String UTILITY_CLASS = "Utility class";
    public static final String SERVER_PING_MESSAGE = "Conexión correcta con Procesos de autoevaluación";

    //EXCEPCIONES
    public static final Integer BAD_REQUEST_STATUS = 400;
    public static final String APPLICATION_EXCEPTION = "Application Exception";
    public static final String DATA_EXCEPTION = "Data Exception";
    public static final String CONSTRAINT_VIOLATION_EXCEPTION = "Constraint Violation Exception";
}
