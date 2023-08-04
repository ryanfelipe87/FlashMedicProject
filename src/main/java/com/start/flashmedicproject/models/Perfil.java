package com.start.flashmedicproject.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}
