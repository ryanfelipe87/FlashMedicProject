package com.start.flashmedicproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private LocalDate nascimento;

    @Column
    private String cpf;

    @Column
    private String civilStatus;

    @Column
    private String gender;

    @Column
    private String address;

    @Column
    private String cellPhone;

    @Column
    @Email
    private String email;

    @Column
    private String password;

    @Column
    private String sus;

    @Column
    private String bloodType;

    @Column
    private int numFicha;

    @Column
    private Timestamp dateRegister;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "paciente_opcao",
            joinColumns = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns = @JoinColumn(name = "opcao_id")
    )
    private Set<Opcao> opcoes;
}
