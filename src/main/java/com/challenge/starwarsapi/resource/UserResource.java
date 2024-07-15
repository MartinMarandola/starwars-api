package com.challenge.starwarsapi.resource;

import com.challenge.starwarsapi.model.dto.AddUserDTO;
import com.challenge.starwarsapi.model.dto.ApiResponseDTO;
import com.challenge.starwarsapi.model.dto.UserLoginDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Tag(name = "User API Resources", description = "User API Controller")
public interface UserResource {

    @Operation(
            summary = "User sign up based on name, email, password",
            description = "Once the user is registered an user role will be assigned to it"

    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)
    })
    ResponseEntity<ApiResponseDTO<AddUserDTO>> userSignUp(
            @RequestBody(description = "User request data for sign up", required = true) Map<String, String> requestMap);

    @Operation(
            summary = "User login based on email and password",
            description = "Once the user is authenticated a JWT token will be generated"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)
    })
    ResponseEntity<ApiResponseDTO<UserLoginDTO>> login(
            @RequestBody(description = "User email and password data", required = true) Map<String, String> requestMap);

}
