package com.start.flashmedicproject.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Entity
@Data
public class GenerateNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private static List<Integer> fichas = new ArrayList<>();
    private static Random random = new Random();

    public GenerateNumber() {
    }

    public static synchronized int generateNextFicha(){
        int numberFicha = random.nextInt(1000) + 1;
        while (fichas.contains(numberFicha)){
            numberFicha = random.nextInt(1000) + 1;
        }

        fichas.add(numberFicha);
        Collections.sort(fichas);
        return numberFicha;
    }

    @ManyToMany
    @JoinColumn(name = "paciente_id")
    private List<Paciente> paciente;
}
