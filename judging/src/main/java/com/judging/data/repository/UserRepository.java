package com.judging.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.judging.data.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
  User findByNameIgnoreCase(String name);
}
