package com.aluracursos.Foro.Hub.domain.user;

import jakarta.validation.constraints.NotNull;

public record DTOUsersCourses(
        @NotNull
        Long user_id,
        @NotNull
        Long course_id
) {
}
