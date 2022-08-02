package com.example.coursework2spring.impl;

import com.example.coursework2spring.data.Question;
import com.example.coursework2spring.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {



    private static final Random random = new Random();

    private final Set<Question> questions;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question addQuestion = new Question(question, answer);
        questions.add(addQuestion);
        return addQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(random.nextInt(questions.size()));
    }
}
