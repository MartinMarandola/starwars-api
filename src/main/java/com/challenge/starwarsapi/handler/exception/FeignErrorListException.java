package com.challenge.starwarsapi.handler.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
public class FeignErrorListException extends RuntimeException {
    private final int status;

    public FeignErrorListException(int status, String message) {
        super(message);
        this.status = status;
    }

}
