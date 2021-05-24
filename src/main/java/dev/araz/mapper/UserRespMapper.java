package dev.araz.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.araz.dto.UserRespDto;
import dev.araz.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRespMapper<E, D> implements MapperDto<User, UserRespDto> {

    private final ObjectMapper mapper;

    @Override
    public User toEntity(UserRespDto dto) {
        return mapper.convertValue(dto, User.class);
    }

    @Override
    public UserRespDto toDto(User entity) {
        return mapper.convertValue(entity, UserRespDto.class);
    }
}