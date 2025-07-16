package com.personal.crud.controller;

import com.personal.crud.model.TechUser;
import com.personal.crud.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<TechUser> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public TechUser getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }


}
