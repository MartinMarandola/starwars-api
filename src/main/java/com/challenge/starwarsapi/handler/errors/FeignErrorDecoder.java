package com.challenge.starwarsapi.handler.errors;

import com.challenge.starwarsapi.handler.exception.FeignErrorListException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus status = HttpStatus.valueOf(response.status());
        String message = switch (status) {
            case BAD_REQUEST -> "Bad request made to the server";
            case UNAUTHORIZED -> "Unauthorized request";
            case FORBIDDEN -> "Forbidden request";
            case NOT_FOUND -> "Requested resource not found";
            case INTERNAL_SERVER_ERROR -> "Internal server error";
            default -> "Generic error";
        };

        return new FeignErrorListException(status.value(), message);
    }


}
