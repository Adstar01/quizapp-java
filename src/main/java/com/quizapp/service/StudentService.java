package com.quizapp.service;

import com.quizapp.entity.Question;
import com.quizapp.entity.QuizHistory;
import com.quizapp.repository.QuestionRepository;
import com.quizapp.repository.QuizHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private QuizHistoryRepository quizHistoryRepository;

    @Autowired
    private QuestionRepository questionRepository;

    // Fetch quiz history for a student
    public List<QuizHistory> getStudentQuizHistory(int studentId) {
        return quizHistoryRepository.findByStudentId(studentId);
    }

    // Fetch random questions based on difficulty
    public List<Question> getQuestionsByDifficulty(String difficulty, int count) {
        List<Question> allQuestions = questionRepository.findByDifficulty(difficulty);
        return allQuestions.stream().limit(count).collect(Collectors.toList());
    }
}
