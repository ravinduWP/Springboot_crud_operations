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

    public void addTechUser(TechUser techUser) {
        userRepository.save(techUser);
    }

    public void updateTechUser(Integer id, TechUser update) {
        TechUser techUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + "not found"));
        techUser.setName(update.getName());
        techUser.setTechStack(update.getTechStack());
        userRepository.save(techUser);

    }


    public void deleteTechUser(Integer id) {
        boolean exists = userRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(id + "not found");
        }
        userRepository.deleteById(id);
    }
}
