package com.aluracursos.Foro.Hub.domain.course;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Course")
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String course_name;
    @Enumerated(EnumType.STRING)
    private CourseCategory category;

    public Course(DTOCourse dtoCourse){
        this.course_name = dtoCourse.course_name();
        this.category = dtoCourse.category();
    }
}
