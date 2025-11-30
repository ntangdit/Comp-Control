package com.judging.controller;

import com.judging.dto.UserCreateArgs;
import com.judging.service.UserService;
import org.springframework.web.bind.annotation.*;

import com.judging.data.entity.User;
import com.judging.data.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserRepository userRepository;
  private final UserService userService;

  public UserController(UserRepository userRepository, UserService userService) {
    this.userRepository = userRepository;
    this.userService = userService;
  }

  @GetMapping
  public User getUser(@RequestParam("name") String name) {
    return this.userRepository.findByNameIgnoreCase(name);
  }

  @PostMapping
  public String createUser(@RequestBody UserCreateArgs userCreateArgs) {
    return userService.createUser(userCreateArgs);
  }
}
