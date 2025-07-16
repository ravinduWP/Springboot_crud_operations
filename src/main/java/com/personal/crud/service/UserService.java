package com.personal.crud.service;

import com.personal.crud.model.TechUser;
import com.personal.crud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<TechUser> getAllUsers(){
        return userRepository.findAll();
    }

    public TechUser getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + "not found"));
    }
}
