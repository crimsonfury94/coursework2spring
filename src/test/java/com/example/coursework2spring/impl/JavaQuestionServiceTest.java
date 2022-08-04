package com.example.coursework2spring.impl;

import com.example.coursework2spring.data.Question;
import com.example.coursework2spring.exception.QuestionAlreadyAddedException;
import com.example.coursework2spring.exception.QuestionNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();


    @ParameterizedTest
    @MethodSource("paramsForString")
    void add(String question, String answer) {
        javaQuestionService.add(question, answer);
        assertThatExceptionOfType(QuestionAlreadyAddedException.class)
                .isThrownBy(() -> javaQuestionService.add(question, answer));
        assertThat(javaQuestionService.getAll()).containsExactlyInAnyOrder(new Question(question, answer));

    }

    @ParameterizedTest
    @MethodSource("paramsForObjects")
    void testAdd(Question question) {
        javaQuestionService.add(question);
        assertThatExceptionOfType(QuestionAlreadyAddedException.class)
                .isThrownBy(() -> javaQuestionService.add(question));
        assertThat(javaQuestionService.getAll()).containsExactlyInAnyOrder(question);
    }

    @ParameterizedTest
    @MethodSource("paramsForObjects")
    void remove(Question question) {
        javaQuestionService.add(question);
        javaQuestionService.remove(question);
        assertThat(javaQuestionService.getAll()).isEmpty();
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> javaQuestionService.remove(question));
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

    @ParameterizedTest
    @MethodSource("paramsForRandom")
    void getRandomQuestion(Set<Question> questions) {
        questions.forEach(javaQuestionService::add);
        assertThat(javaQuestionService.getAll()).hasSize(questions.size());
        assertThat(javaQuestionService.getRandomQuestion()).isIn(javaQuestionService.getAll());
    }

    private static Stream<Arguments> paramsForObjects() {
        return Stream.of(
                Arguments.of(new Question("test1", "test1")),
                Arguments.of(new Question("test2", "test2")),
                Arguments.of(new Question("test3", "test3")));
    }

    private static Stream<Arguments> paramsForString() {
        return Stream.of(
                Arguments.of("test1", "test1"),
                Arguments.of("test2", "test2"),
                Arguments.of("test3", "test3"));
    }

    private static Stream<Arguments> paramsForRandom() {
        return Stream.of(
                Arguments.of(
                        Set.of(
                                new Question("test1", "test1"),
                                new Question("test2", "test2"),
                                new Question("test3", "test3")
                        )
                )
        );
    }
}