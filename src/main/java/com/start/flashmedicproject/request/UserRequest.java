package com.start.flashmedicproject.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequest {

    @NotEmpty(message = "Não pode ser nulo")
    @NotBlank(message = "Não pode estar em branco")
    @NotNull(message = "Não pode estar vazio")
    private String email;

    @NotEmpty(message = "Não pode ser nulo")
    @NotBlank(message = "Não pode estar em branco")
    @NotNull(message = "Não pode estar vazio")
    private String password;

    private String mensagem;
}
