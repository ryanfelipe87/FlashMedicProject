package com.start.flashmedicproject.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "paciente")
public class Paciente extends Endereco{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private LocalDate dataNascimento;

    @Column
    private String cpf;

    @Column
    private String civilStatus;

    @Column
    private String gender;

    @Column
    private String cellPhone;

    @Column
    private String sus;

    @Column
    private String bloodType;

    @Column
    private String numberFicha;

    @Column
    private LocalDateTime dateRegister;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
