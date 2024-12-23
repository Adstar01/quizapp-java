package com.quizapp.service;

import com.quizapp.entity.Question;
import com.quizapp.entity.QuizHistory;
import com.quizapp.entity.Student;
import com.quizapp.repository.QuestionRepository;
import com.quizapp.repository.QuizHistoryRepository;
import com.quizapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizHistoryRepository quizHistoryRepository;

    // Fetch all registered students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Fetch quiz history
    public List<QuizHistory> getQuizHistory() {
        return quizHistoryRepository.findAll();
    }

    // Register a new student
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    // Add a new question
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }
}
