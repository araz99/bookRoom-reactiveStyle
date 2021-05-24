package dev.araz.controller;

import dev.araz.dto.UserReqDto;
import dev.araz.dto.UserRespDto;
import dev.araz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public Mono<UserRespDto> addUser(@RequestBody UserReqDto userReqDto) {
       return userService.saveUser(userReqDto);
    }
}