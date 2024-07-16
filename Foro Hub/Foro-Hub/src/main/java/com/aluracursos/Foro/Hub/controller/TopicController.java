package com.aluracursos.Foro.Hub.controller;


import com.aluracursos.Foro.Hub.domain.answer.Answer;
import com.aluracursos.Foro.Hub.domain.answer.AnswerRepository;
import com.aluracursos.Foro.Hub.domain.answer.DTOAnswer;
import com.aluracursos.Foro.Hub.domain.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping
    @Transactional
    public void createTopic(@RequestBody @Valid DTOTopic dtoTopic){
        topicRepository.save(new Topic(dtoTopic));
    }

    @PostMapping("/answers")
    @Transactional
    public void createAnswer(@RequestBody @Valid DTOAnswer dtoAnswer){
        answerRepository.save(new Answer(dtoAnswer));
    }

    @GetMapping
    public ResponseEntity<Page<DTOGetTopics>> listTopics(@PageableDefault(size = 10) Pageable pagination) {
        return ResponseEntity.ok(topicRepository.findAll(pagination).map(DTOGetTopics::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOGetTopics> listTopic(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        var topicData = new DTOGetTopics(topic.getTitle(),
                topic.getMessage(),
                topic.getCreated(),
                topic.getStatus(),
                topic.getUser_id(),
                topic.getCourse_id());
        return ResponseEntity.ok(topicData);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTopic(@RequestBody @Valid DTOUpdateTopic dtoUpdateTopic) {
        Topic topic = topicRepository.getReferenceById(dtoUpdateTopic.id());
        topic.update(dtoUpdateTopic);
        var topicData = new DTOGetTopics(topic.getTitle(),
                topic.getMessage(),
                topic.getCreated(),
                topic.getStatus(),
                topic.getUser_id(),
                topic.getCourse_id());
        return ResponseEntity.ok(topicData);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        topic.delete();
        return ResponseEntity.noContent().build();
    }
}
