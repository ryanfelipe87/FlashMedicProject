package com.start.flashmedicproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Data
@Getter @Setter
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
