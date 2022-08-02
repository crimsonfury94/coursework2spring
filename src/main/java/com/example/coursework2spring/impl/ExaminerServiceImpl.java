package com.example.coursework2spring.impl;

import com.example.coursework2spring.data.Question;
import com.example.coursework2spring.exception.InvalidAmountException;
import com.example.coursework2spring.service.ExaminerService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionSet = new HashSet<>();
        if (amount < 0 || amount > javaQuestionService.getAll().size()) {
            throw new InvalidAmountException();
        }
        while (questionSet.size() < amount) {
            questionSet.add(javaQuestionService.getRandomQuestion());
        }
        return questionSet;
    }
}
