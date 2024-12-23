package com.quizapp.repository;

import com.quizapp.entity.QuizHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizHistoryRepository extends JpaRepository<QuizHistory, Integer> {
    List<QuizHistory> findByStudentId(int studentId);
}
