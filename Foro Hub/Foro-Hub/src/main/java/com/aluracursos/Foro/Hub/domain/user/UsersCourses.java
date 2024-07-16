package com.aluracursos.Foro.Hub.domain.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "UsersCourses")
@Table(name = "userscourses")
public class UsersCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Long user_id;
    Long course_id;
    LocalDateTime enrolled;
    Boolean active;

    public UsersCourses(DTOUsersCourses dtoUsersCourses){
        this.user_id = dtoUsersCourses.user_id();
        this.course_id = dtoUsersCourses.course_id();
        this.enrolled = LocalDateTime.now();
        this.active = true;
    }
}
