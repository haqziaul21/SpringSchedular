package com.schedular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schedular.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
