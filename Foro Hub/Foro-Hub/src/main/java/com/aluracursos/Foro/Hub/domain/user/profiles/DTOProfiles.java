package com.aluracursos.Foro.Hub.domain.user.profiles;

import jakarta.validation.constraints.NotNull;

public record DTOProfiles(
        @NotNull
        Long user_id,
        @NotNull
        Long profile_id
) {
}
