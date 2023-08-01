package com.start.flashmedicproject.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String email;
    private String password;
    private String mensagem;
}
