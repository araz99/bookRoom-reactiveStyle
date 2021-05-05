package dev.araz.service;

import dev.araz.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void saveUser(UserDto userDto);
}