package com.personal.crud.controller;

import com.personal.crud.model.TechUser;
import com.personal.crud.service.UserService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public void addNewTechUser(@RequestBody TechUser techUser){
        userService.addTechUser(techUser);
    }

    @PutMapping("{id}")
    public void updateTechUser(@PathVariable Integer id,@RequestBody TechUser techUser){
        userService.updateTechUser(id,techUser);
    }

    @DeleteMapping("{id}")
    public void deleteTechUser(@PathVariable Integer id){
        userService.deleteTechUser(id);
    }
}
