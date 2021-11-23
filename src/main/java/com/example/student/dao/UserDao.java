package com.example.student.dao;

import com.example.student.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
