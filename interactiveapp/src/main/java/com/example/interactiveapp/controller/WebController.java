package com.example.interactiveapp.controller;

import com.example.interactiveapp.model.User;
import com.example.interactiveapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private UserRepository userRepository;

    // Home page - list all users
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    // Add user page
    @GetMapping("/add-user")
    public String addUserForm(User user) {
        return "add-user";
    }

    // Save user from form
    @PostMapping("/add-user")
    public String saveUser(User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    // Delete user
    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/";
    }
}
