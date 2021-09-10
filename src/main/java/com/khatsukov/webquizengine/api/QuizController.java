package com.khatsukov.webquizengine.api;

import com.khatsukov.webquizengine.entities.Feedback;
import com.khatsukov.webquizengine.entities.Quiz;
import com.khatsukov.webquizengine.model.AnswerDTO;
import com.khatsukov.webquizengine.model.QuizDTO;
import com.khatsukov.webquizengine.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping(value = "/quizzes", produces = MediaType.APPLICATION_JSON_VALUE)
    public QuizDTO addQuestion(@RequestBody QuizDTO quiz) {
        return new QuizDTO(quizService.create(quiz));
    }

    @GetMapping(value = "/quizzes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuizDTO> getQuiz(@PathVariable long id) {
        Optional<Quiz> quiz = quizService.get(id);
        return quiz.map(value -> ResponseEntity.ok(new QuizDTO(quiz.get()))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/quizzes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuizDTO> getQuizzes() {
        return quizService.getAll();
    }

    @PostMapping(value = "/quizzes/{id}/solve", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Feedback> solveQuiz(@PathVariable long id, @RequestBody AnswerDTO answer) {
        Optional<Quiz> quiz = quizService.get(id);
        return quiz.map(value -> ResponseEntity.ok(quizService.solve(value, answer)))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
