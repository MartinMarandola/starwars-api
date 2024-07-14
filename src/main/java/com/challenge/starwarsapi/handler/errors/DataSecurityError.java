package com.challenge.starwarsapi.handler.errors;

import lombok.Data;

@Data
public class DataSecurityError {
    public static final String UNAUTHORIZED = "Unauthorized";
    public static final String FORBIDDEN = "Authentication failed";
}
