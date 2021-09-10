package com.khatsukov.webquizengine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.khatsukov.webquizengine.entities.Quiz;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuizDTO {

    @NotEmpty
    private String title;

    @NotEmpty
    private String text;

    @Size(min = 2)
    @NotNull
    private List<String> options;
    private List<Integer> answer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @JsonIgnore
    public List<Integer> getCorrectIndexes() {
        return answer == null ? new ArrayList<>() : answer;
    }

    @JsonSetter("answer")
    public void setCorrectIndexes(List<Integer> answer) {
        if (Objects.nonNull(answer)) {
            this.answer = answer;
        }
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public QuizDTO(Quiz quiz) {
        this.title = quiz.getTitle();
        this.text = quiz.getText();
        this.options = quiz.getOptions();
    }

    public QuizDTO() {

    }
}