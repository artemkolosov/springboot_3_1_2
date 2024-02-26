package ru.artemkolosov.springboot_3_1_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.artemkolosov.springboot_3_1_2.model.User;
import ru.artemkolosov.springboot_3_1_2.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    //INTRO

    @GetMapping(value = "/")

    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("CRUD приложение");
        messages.add("реализованное через Springboot");
        messages.add("февраль 2024");
        messages.add("Студент Колосов Артём");
        model.addAttribute("messages", messages);
        return "index";
    }

    //CREATE

    @GetMapping("/useradd")
    public String createUserForm(User user){
        return "useradd";
    }

    @PostMapping("/useradd")
    public String createUser(User user){
        userService.addUser(user);
        return "redirect:/users";
    }

    //READ

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";

    }
    //UPDATE

    @GetMapping("/useredit/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "useredit";
    }

    @PostMapping("/useredit")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }

    //DELETE

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }


}
