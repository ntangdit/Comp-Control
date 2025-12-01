package com.judging.service.impl;

import com.judging.data.entity.User;
import com.judging.data.repository.UserRepository;
import com.judging.dto.UserCreateArgs;
import com.judging.service.UserService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(UserCreateArgs userCreateArgs) {
        User user = new User();
        Instant createTime = Instant.now();
        user.setName(userCreateArgs.name());
        user.setCreatedAt(createTime);
        // Service to save pic

        // save info to User db
        userRepository.save(user);
        return "userCreated";
    }
}
