package com.Spring_Boot.spring.springboot_rest.controllers;

import com.Spring_Boot.spring.springboot_rest.model.User;
import com.Spring_Boot.spring.springboot_rest.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }




    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", userService.getById(id));
        return "show";
    }

    @GetMapping("/(id)/edit")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", userService.getById(id));

        return "edit";
    }

    @DeleteMapping("/(id)/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @PatchMapping("/(id)")
    public String updateUser(@ModelAttribute("users") User user, @PathVariable("id") int id) {
        userService.edit(user);
        return "redirect:/users";

    }

    @PostMapping("/(user)/add")
    public String addUsers(@ModelAttribute("users") User user) {
        userService.add(user);

        return "redirect:/users";

    }



}
