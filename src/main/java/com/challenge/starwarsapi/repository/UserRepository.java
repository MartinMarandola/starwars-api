package com.challenge.starwarsapi.repository;

import com.challenge.starwarsapi.model.User;
import com.challenge.starwarsapi.model.dto.user.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(@Param(("email")) String email);
    List<UserDTO> getAllUsers();

}
