package com.example.coursework2spring.controller;

import com.example.coursework2spring.data.Question;
import com.example.coursework2spring.impl.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add")
    public Question add(String question, String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(Question question) {
        return javaQuestionService.remove(question);
    }

    @GetMapping(path = "/find")
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }
}
