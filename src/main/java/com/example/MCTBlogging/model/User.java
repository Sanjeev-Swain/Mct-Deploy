package com.example.MCTBlogging.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @NotBlank(message = "username cannot be empty")
    @Column(name = "username")
    private String userName;

    @NotBlank(message = "password id mandatory")
    @Column(name = "password")
    private String password;
    @NotBlank(message = "firstname is mandatory")
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Email(message = "email should be in correct format")
    @Column(name = "email")
    private String email;
    @Column(name = "followers")
    private int followers;
}
