package com.unicauca.procesos.mapper;

import com.unicauca.procesos.common.Constants;
import com.unicauca.procesos.dto.ExceptionResponse;

public final class ExceptionMapper {

    private ExceptionMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static ExceptionResponse mapApplicationException(String message) {
//        return ExceptionResponse.builder()
//                .status(Constants.BAD_REQUEST_STATUS)
//                .error(Constants.APPLICATION_EXCEPTION)
//                .message(message)
//                .build();
    	return null;
    }

    public static ExceptionResponse mapDataException(String message) {
//        return ExceptionResponse.builder()
//                .status(Constants.BAD_REQUEST_STATUS)
//                .error(Constants.DATA_EXCEPTION)
//                .message(message)
//                .build();
    	return null;
    }

    public static ExceptionResponse mapConstraintViolationException(String message) {
//        return ExceptionResponse.builder()
//                .status(Constants.BAD_REQUEST_STATUS)
//                .error(Constants.CONSTRAINT_VIOLATION_EXCEPTION)
//                .message(message)
//                .build();
    	return null;
    }
}
