package com.aluracursos.Foro.Hub.domain.topic;


import java.time.LocalDateTime;

public record DTOGetTopics(
        String title,
        String message,
        LocalDateTime created,
        Status status,
        Long user_id,
        Long course_id
) {

    public DTOGetTopics(Topic topic){
        this(
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreated(),
                topic.getStatus(),
                topic.getUser_id(),
                topic.getCourse_id()
        );
    }
}
