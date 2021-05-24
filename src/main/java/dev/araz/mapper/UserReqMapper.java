package dev.araz.mapper;

import dev.araz.dto.UserReqDto;
import dev.araz.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserReqMapper implements MapperDto<User, UserReqDto> {

    private final ObjectMapper mapper;

    @Override
    public User toEntity(UserReqDto dto) {
        return mapper.convertValue(dto, User.class);
    }

    @Override
    public UserReqDto toDto(User entity) {
        return mapper.convertValue(entity, UserReqDto.class);
    }
}
