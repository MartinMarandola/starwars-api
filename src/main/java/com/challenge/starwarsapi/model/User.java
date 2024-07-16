package com.challenge.starwarsapi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email=:email")
@NamedQuery(name = "User.getAllUsers",query = "select new com.challenge.starwarsapi.model.dto.user.UserDTO(u.id,u.name,u.email,u.role) from User u where u.role='user'")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

}
