package com.start.flashmedicproject.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "opcoes")
public class Opcao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String opcao1;

    @Column
    private String opcao2;

    @Column
    private String opcao3;

    @Column
    private String opcao4;

    @Column
    private String opcao5;

    @Column
    private String opcao6;

    @Column
    private String opcao7;

    @Column
    private String opcao8;

    @Column
    private String opcao9;

    @Column
    private String opcao10;

    @Column
    private String name;
}
