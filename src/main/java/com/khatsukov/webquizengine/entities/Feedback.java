package com.khatsukov.webquizengine.entities;

import com.fasterxml.jackson.annotation.JsonGetter;


public class Feedback {
    private boolean success;
    private static final String CORRECT_ANSWER = "Congratulations, you're right!";
    private static final String WRONG_ANSWER = "Wrong answer! Please, try again.";

    public Feedback(boolean isAnswerCorrect) {
        this.success = isAnswerCorrect;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setAnswerCorrect(boolean answerCorrect) {
        success = answerCorrect;
    }

    @JsonGetter("feedback")
    public String getFeedbackText() {
        return success ? CORRECT_ANSWER : WRONG_ANSWER;
    }
}
