package com.nttdata.bootcamp.banking.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public class ResponseUtil {

    public static ResponseEntity<ApiResponse> success(Object data) {
        return ResponseEntity.ok(ApiResponse.success("Find Account",
                "Successful result", data));
    }

    public static Mono<ResponseEntity<ApiResponse>> failed(String messageError) {
        return Mono.just(new ResponseEntity<>(ApiResponse.failed(messageError, HttpStatus.INTERNAL_SERVER_ERROR.value()),
                HttpStatus.INTERNAL_SERVER_ERROR));
    }

}
