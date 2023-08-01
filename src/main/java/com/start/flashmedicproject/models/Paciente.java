package com.start.flashmedicproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Data
@Getter @Setter
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotBlank(message = "Este campo não pode estar vazio")
    private String name;

    @Column
    @NotNull(message = "Este campo não pode estar vazio")
    private LocalDate nascimento;

    @Column
    @NotBlank(message = "Este campo não pode estar vazio")
    private String cpf;

    @Column
    @NotBlank(message = "Este campo não pode estar vazio")
    private String civilStatus;

    @Column
    @NotBlank(message = "Este campo não pode estar vazio")
    private String gender;

    @Column
    @NotBlank(message = "Este campo não pode estar vazio")
    private String address;

    @Column
    @NotBlank(message = "Este campo não pode estar vazio")
    private String cellPhone;

    @Column
    @NotBlank(message = "Este campo não pode estar vazio")
    private String email;

    @Column
    @NotBlank(message = "Este campo não pode estar vazio")
    private String password;

    @Column
    private String sus;

    @Column
    private String bloodType;

    @Column
    private Timestamp dateRegister;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
