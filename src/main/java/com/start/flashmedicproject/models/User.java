package com.start.flashmedicproject.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "login")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Timestamp dateRegister;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}
