package com.ara.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(schema = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, email, password,Roles;

    public User(String name, String email, String password, String Roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.Roles = Roles;
    }
    public User() {}
}