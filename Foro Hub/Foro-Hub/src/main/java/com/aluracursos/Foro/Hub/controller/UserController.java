package com.aluracursos.Foro.Hub.controller;


import com.aluracursos.Foro.Hub.domain.user.*;
import com.aluracursos.Foro.Hub.domain.user.profiles.DTOProfiles;
import com.aluracursos.Foro.Hub.domain.user.profiles.ProfileRepository;
import com.aluracursos.Foro.Hub.domain.user.profiles.UProfile;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersCoursesRepository usersCoursesRepository;

    @Autowired
    private ProfileRepository profilesRepository;

    @PostMapping
    @Transactional
    public void createUser(@RequestBody @Valid DTOUser dtoUser){
        userRepository.save(new User(dtoUser));
    }

    @PostMapping("/courses")
    @Transactional
    public void enrollUser(@RequestBody @Valid DTOUsersCourses dtoUsersCourses){
        usersCoursesRepository.save(new UsersCourses(dtoUsersCourses));
    }

    @PostMapping("/profiles")
    @Transactional
    public void addUserProfile(@RequestBody @Valid DTOProfiles dtoProfiles){
        profilesRepository.save(new UProfile(dtoProfiles));
    }
}
