package com.example.coursework2spring.impl;

import com.example.coursework2spring.data.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();


    @ParameterizedTest
    @MethodSource("params")
    void add(String question, String answer) {
        Question expected = new Question(question, answer);
        assertThat(javaQuestionService.add(question,answer))
                .isEqualTo(expected);
    }

    @Test
    void testAdd() {
        Question q1 = new Question("test1","test1");
        Question q2 = new Question("test2","test2");
        Question q3 = new Question("test3","test3");

        assertThat(javaQuestionService.add(q1))
                .isEqualTo(q1);
        assertThat(javaQuestionService.add(q2))
                .isEqualTo(q2);
        assertThat(javaQuestionService.add(q3))
                .isEqualTo(q3);
    }

    @Test
    void remove() {
        Question q1 = new Question("test1","test1");
        Question q2 = new Question("test2","test2");
        Question q3 = new Question("test3","test3");

        assertThat(javaQuestionService.remove(q1))
                .isEqualTo(q1);
        assertThat(javaQuestionService.remove(q2))
                .isEqualTo(q2);
        assertThat(javaQuestionService.remove(q3))
                .isEqualTo(q3);
    }



    @Test
    void getAll() {
        Question question1 = new Question("test1", "test1");
        Question question2 = new Question("test2", "test2");
        Question question3 = new Question("test3", "test3");

        javaQuestionService.add("test1", "test1");
        javaQuestionService.add("test2", "test2");
        javaQuestionService.add("test3", "test3");

        Collection<Question> expected = javaQuestionService.getAll();
        Collection<Question> actual = new HashSet<>();

        actual.add(question1);
        actual.add(question2);
        actual.add(question3);

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void notNullTest() {
        JavaQuestionService javaQuestionService = new JavaQuestionService();
        Collection<Question> expected = javaQuestionService.getAll();
        assertThat(expected).isNotNull();
    }

    @Test
    void getRandomQuestion() {
        Random random = new Random();

    }

    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("test1", "test1"),
                Arguments.of("test2", "test2"),
                Arguments.of("test3", "test3"));
    }
}