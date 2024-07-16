package com.challenge.starwarsapi.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User login DTO")
public class UserLoginDTO {
    private int userId;
    private String token;
    private String username;
    private String email;
    private Date expires;
}
