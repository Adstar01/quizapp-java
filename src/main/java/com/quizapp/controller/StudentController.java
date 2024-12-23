package com.quizapp.controller;

import com.quizapp.entity.Question;
import com.quizapp.entity.QuizHistory;
import com.quizapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/quiz-history/{studentId}")
    public List<QuizHistory> getQuizHistory(@PathVariable int studentId) {
        return studentService.getStudentQuizHistory(studentId);
    }

    @GetMapping("/questions")
    public List<Question> getQuestions(@RequestParam String difficulty) {
        return studentService.getQuestionsByDifficulty(difficulty, 5);
    }
}
