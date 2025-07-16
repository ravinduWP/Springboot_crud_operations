package com.personal.crud.repository;

import com.personal.crud.model.TechUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<TechUser,Integer> {
}
