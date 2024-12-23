package com.quizapp.repository;

import com.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByDifficulty(String difficultyLevel);
}
