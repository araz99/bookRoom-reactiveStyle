package dev.araz.service.impl;

import dev.araz.dto.UserReqDto;
import dev.araz.dto.UserRespDto;
import dev.araz.entity.Role;
import dev.araz.entity.User;
import dev.araz.exception.UserExistsException;
import dev.araz.mapper.MapperDto;
import dev.araz.repository.RoleRepository;
import dev.araz.repository.UserRepository;
import dev.araz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MapperDto<User, UserReqDto> reqMapper;
    private final MapperDto<User, UserRespDto> respMapper;
    private final RoleRepository roleRepository;

    @Override
    public Mono<UserRespDto> saveUser(UserReqDto userReqDto) {
        return userRepository
                .findUserByUsername(userReqDto.getUsername())
                .hasElement()
                .flatMap(flag -> {
                    if (flag)
                        return Mono.error(new UserExistsException());

                    Mono<UserRespDto> map = userRepository
                            .save(reqMapper.toEntity(userReqDto))
                            .map(respMapper::toDto);

                    return map;
                });
    }
}