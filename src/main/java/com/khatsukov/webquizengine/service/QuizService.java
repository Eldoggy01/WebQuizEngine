package com.khatsukov.webquizengine.service;

import com.khatsukov.webquizengine.data.QuizRepository;
import com.khatsukov.webquizengine.entities.Feedback;
import com.khatsukov.webquizengine.entities.Quiz;
import com.khatsukov.webquizengine.model.AnswerDTO;
import com.khatsukov.webquizengine.model.QuizDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz create(QuizDTO quizDTO) {
        return quizRepository.save(new Quiz(quizDTO));
    }

    public Optional<Quiz> get(long id) {
        return quizRepository.findById(id);
    }

    public List<QuizDTO> getAll() {
        return quizRepository.findAll().stream()
            .map(QuizDTO::new)
            .collect(Collectors.toList());
    }

    public boolean isExist(long id) {
        return quizRepository.existsById(id);
    }

    public Feedback solve(Quiz quiz, AnswerDTO answer) {
       return new Feedback(Objects.equals(answer.getAnswer(), quiz.getCorrectIndexes()));
    }
}
