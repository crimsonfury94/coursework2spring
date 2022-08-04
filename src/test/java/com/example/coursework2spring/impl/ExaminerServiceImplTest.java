package com.example.coursework2spring.impl;

import com.example.coursework2spring.data.Question;
import com.example.coursework2spring.exception.InvalidAmountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        List<Question> question = new ArrayList<>();
        question.add(new Question("test1", "test1"));
        question.add(new Question("test2", "test2"));
        question.add(new Question("test3", "test3"));
        question.add(new Question("test4", "test4"));
        question.add(new Question("test5", "test5"));

        when(javaQuestionService.getAll()).thenReturn(question);
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(question.get(0), question.get(1), question.get(3), question.get(2), question.get(3));
        assertThat(examinerService.getQuestions(3))
                .containsExactlyInAnyOrder(question.get(0), question.get(1), question.get(3));
    }

    @Test
    void exceptionTest() {
        assertThatExceptionOfType(InvalidAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(6));

        assertThatExceptionOfType(InvalidAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
    }


}