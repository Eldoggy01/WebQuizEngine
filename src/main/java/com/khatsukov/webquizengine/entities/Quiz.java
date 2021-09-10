package com.khatsukov.webquizengine.entities;

import com.khatsukov.webquizengine.model.QuizDTO;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.List;


@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String text;

    @Size(min = 2)
    @ElementCollection()
    private List<String> options;

    @ElementCollection
    private List<Integer> correctIndexes;

    public Quiz(String title, String text, List<String> options) {
        this.title = title;
        this.text = text;
        this.options = options;
    }

    public Quiz() {

    }
    public Quiz(QuizDTO quizDTO) {
        this.text = quizDTO.getText();
        this.title = quizDTO.getTitle();
        this.options = quizDTO.getOptions();
        this.correctIndexes = quizDTO.getCorrectIndexes();

    }

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

    public List<Integer> getCorrectIndexes() {
        return correctIndexes;
    }

}
