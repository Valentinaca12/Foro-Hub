package com.aluracursos.Foro.Hub.domain.answer;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Answer")
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private Long topic_id;
    private LocalDateTime created;
    private Long user_id;
    private Boolean solved;
    private Integer score;

    public Answer(DTOAnswer dtoAswer){
        this.message = dtoAswer.message();
        this.topic_id = dtoAswer.topic_id();
        this.created = LocalDateTime.now();
        this.user_id = dtoAswer.user_id();
        this.solved = false;
        this.score = 0;
    }
}
