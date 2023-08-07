package com.start.flashmedicproject.dtos;

import com.start.flashmedicproject.models.Endereco;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RegisterPacienteDto extends Endereco {
    private String name;
    private LocalDate dataNascimento;
    private String cpf;
    private String civilStatus;
    private String gender;
    private String cellPhone;
    private String sus;
    private String bloodType;
    private Integer numberFicha;
    private LocalDateTime dateRegister;
    private String email;
    private String password;
}
