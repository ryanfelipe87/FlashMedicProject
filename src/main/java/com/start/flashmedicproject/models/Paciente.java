package com.start.flashmedicproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Este campo não pode estar vazio")
    private String name;

    @NotBlank(message = "Este campo não pode estar vazio")
    private LocalDate nascimento;

    @NotBlank(message = "Este campo não pode estar vazio")
    private String cpf;

    @NotBlank(message = "Este campo não pode estar vazio")
    private String civilStatus;

    @NotBlank(message = "Este campo não pode estar vazio")
    private String gender;

    @NotBlank(message = "Este campo não pode estar vazio")
    private String address;

    @NotBlank(message = "Este campo não pode estar vazio")
    private String cellPhone;

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
