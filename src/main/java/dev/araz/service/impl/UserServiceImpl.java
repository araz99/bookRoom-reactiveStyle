package dev.araz.service.impl;

import dev.araz.dto.UserDto;
import dev.araz.entity.User;
import dev.araz.mapper.MapperDto;
import dev.araz.repository.UserRepository;
import dev.araz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MapperDto<User, UserDto> mapper;

    @Override
    public void saveUser(UserDto userDto) {
//        userRepository.findUserByUsername(userDto.getUsername());
        userRepository.save(mapper.toEntity(userDto)).subscribe();
    }
}