package com.start.flashmedicproject.models;

import jakarta.persistence.*;
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
    private String email;

    @Column
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
