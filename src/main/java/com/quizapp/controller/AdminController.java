package com.quizapp.controller;

import com.quizapp.entity.Question;
import com.quizapp.entity.QuizHistory;
import com.quizapp.entity.Student;
import com.quizapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return adminService.getAllStudents();
    }

    @GetMapping("/quiz-history")
    public List<QuizHistory> getQuizHistory() {
        return adminService.getQuizHistory();
    }

    @PostMapping("/register-student")
    public Student registerStudent(@RequestBody Student student) {
        return adminService.registerStudent(student);
    }

    @PostMapping("/add-question")
    public Question addQuestion(@RequestBody Question question) {
        return adminService.addQuestion(question);
    }
}
