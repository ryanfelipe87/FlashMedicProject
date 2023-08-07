package com.start.flashmedicproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Data
@Table(name = "login")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Email
    private String email;

    @Column
    private String password;

    @OneToOne(mappedBy = "user")
    private Paciente paciente;

}
