package com.example.coursework2spring.impl;

import com.example.coursework2spring.data.Question;
import com.example.coursework2spring.service.ExaminerService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
