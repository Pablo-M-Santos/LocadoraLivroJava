package com.locadora.locadoraLivro.users.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String password;
    private UserRoleEnum role;

    public UserModel(String name, String email, String password, UserRoleEnum role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
