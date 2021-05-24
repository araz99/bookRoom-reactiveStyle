package dev.araz.service;

import dev.araz.dto.UserReqDto;
import dev.araz.dto.UserRespDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface UserService {
    Mono<UserRespDto> saveUser(UserReqDto userReqDto);
}