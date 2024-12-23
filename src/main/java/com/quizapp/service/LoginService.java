package com.quizapp.service;

import com.quizapp.entity.Admin;
import com.quizapp.entity.Student;
import com.quizapp.repository.AdminRepository;
import com.quizapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Verify admin login
    public boolean verifyAdminLogin(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
        return admin != null && admin.getPassword().equals(password);
    }

    // Verify student login
    public boolean verifyStudentLogin(String username, String password) {
        Student student = studentRepository.findByUsername(username);
        return student != null && student.getPassword().equals(password);
    }
}
