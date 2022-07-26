package com.example.coursework2spring.service;

import com.example.coursework2spring.data.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
