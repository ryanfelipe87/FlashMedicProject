package com.start.flashmedicproject.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Endereco {
    @Column
    private String address;

    @Column
    private String neighborhood;

    @Column
    private String cep;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String country;
}
