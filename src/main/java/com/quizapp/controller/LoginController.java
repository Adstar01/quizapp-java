package com.quizapp.controller;

import com.quizapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/admin")
    public boolean adminLogin(@RequestParam String username, @RequestParam String password) {
        return loginService.verifyAdminLogin(username, password);
    }

    @PostMapping("/student")
    public boolean studentLogin(@RequestParam String username, @RequestParam String password) {
        return loginService.verifyStudentLogin(username, password);
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password) {
        // Placeholder logic for login validation
        if ("admin".equals(username) && "password".equals(password)) {
            return "redirect:/admin"; // Redirect to admin page
        } else {
            return "redirect:/student"; // Redirect to student page
        }
    }
}
