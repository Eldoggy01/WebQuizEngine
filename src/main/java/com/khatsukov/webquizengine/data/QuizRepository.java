package com.khatsukov.webquizengine.data;

import com.khatsukov.webquizengine.entities.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * todo Document type QuizRepository
 */

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {
    List<Quiz> findAll();
}
