package com.aluracursos.Foro.Hub.domain.answer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOAnswer(
        @NotBlank
        String message,
        @NotNull
        Long topic_id,
        @NotNull
        Long user_id
) {
}
