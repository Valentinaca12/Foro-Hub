package com.aluracursos.Foro.Hub.domain.topic;

import ch.qos.logback.core.status.Status;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.aspectj.apache.bcel.generic.Tag;

public record DTOUpdateTopic(
        @NotNull
        Long id,
        @Size(min = 0, max = 100)
        String title,
        @Size(min = 0, max = 2000)
        String message,
        Status status,
        Tag tag
) {
}
