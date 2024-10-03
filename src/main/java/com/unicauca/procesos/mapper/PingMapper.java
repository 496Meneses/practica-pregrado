package com.unicauca.procesos.mapper;

import com.unicauca.procesos.dto.PingResponse;
import com.unicauca.procesos.common.Constants;

public final class PingMapper {

    private PingMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static PingResponse buildDTO(String message) {
//        return PingResponse.builder()
//                .message(message)
//                .date(Util.getDateTimeString())
//                .build();
    	return null;
    }
}
