package dev.araz.mapper;

import dev.araz.dto.UserDto;
import dev.araz.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper implements MapperDto<User, UserDto> {

    private final ObjectMapper mapper;

    @Override
    public User toEntity(UserDto dto) {
        return mapper.convertValue(dto, User.class);
    }

    @Override
    public UserDto toDto(User entity) {
        return mapper.convertValue(entity, UserDto.class);
    }
}
