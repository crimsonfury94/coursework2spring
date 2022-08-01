package com.example.coursework2spring.impl;

import com.example.coursework2spring.data.Question;
import com.example.coursework2spring.service.ExaminerService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;
    private static final Random random = new Random();

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionSet = new HashSet<>();
            if (amount < 0 || amount > questionSet.size()) {
                throw new RuntimeException();
            }

            do{
                amount++;
            }
        while (questionSet.size() < amount); {
            questionSet.add(javaQuestionService.getRandomQuestion());
        }
        return javaQuestionService.getAll();
    }
}
