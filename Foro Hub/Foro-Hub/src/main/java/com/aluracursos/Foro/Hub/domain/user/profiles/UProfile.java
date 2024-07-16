package com.aluracursos.Foro.Hub.domain.user.profiles;


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
@Entity(name = "UProfile")
@Table(name = "userprofiles")
public class UProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Long user_id;
    Long profile_id;
    LocalDateTime created;
    Boolean allowed;

    public UProfile(DTOProfiles dtoProfiles){
        this.user_id = dtoProfiles.user_id();
        this.profile_id = dtoProfiles.profile_id();
        this.created = LocalDateTime.now();
        this.allowed = true;
    }
}
