package com.judging.service;

import com.judging.dto.UserCreateArgs;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


public interface UserService {
    String createUser(UserCreateArgs userCreateArgs);
}
