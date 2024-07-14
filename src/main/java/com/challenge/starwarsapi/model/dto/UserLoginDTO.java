package com.challenge.starwarsapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    private int userId;
    private String token;
    private String username;
    private String email;
    private Date expires;
}
