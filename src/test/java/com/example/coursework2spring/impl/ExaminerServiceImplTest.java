package com.example.coursework2spring.impl;

import com.example.coursework2spring.data.Question;
import com.example.coursework2spring.exception.InvalidAmountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
        Question question1 = new Question("test1", "test1");
        Question question2 = new Question("test2", "test2");
        Question question3 = new Question("test3", "test3");
        Question question4 = new Question("test4", "test4");
        Question question5 = new Question("test5", "test5");

        Collection<Question> expected = new HashSet<>(Set.of(question1, question2, question3,
                question4, question5));
        when(javaQuestionService.getAll()).thenReturn(expected);
        assertThatExceptionOfType(InvalidAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(6));
    }

    @Test
    void exceptionTest() {
        assertThatExceptionOfType(InvalidAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(6));
    }


}