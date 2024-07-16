package com.aluracursos.Foro.Hub.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record DTOUser(
        @NotBlank
        String first_name,
        @NotBlank
        String last_name,
        @NotBlank
        String username,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password
) {
}
