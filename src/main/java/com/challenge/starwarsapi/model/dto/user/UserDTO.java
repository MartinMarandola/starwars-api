package com.challenge.starwarsapi.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "User DTO")
public class UserDTO {
    private Integer id;
    private String name;
    private String email;
    private String role;
}
