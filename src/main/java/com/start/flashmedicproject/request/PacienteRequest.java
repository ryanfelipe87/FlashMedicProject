package com.start.flashmedicproject.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PacienteRequest {

    @NotEmpty(message = "Não pode ser nulo")
    @NotBlank(message = "Não pode estar em branco")
    @NotNull(message = "Não pode estar vazio")
    private String name;

    @NotNull(message = "Este campo não pode estar nulo")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate nascimento;
}
