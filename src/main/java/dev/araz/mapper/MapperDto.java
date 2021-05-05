package dev.araz.mapper;

import org.springframework.stereotype.Component;

@Component
public interface MapperDto<E, D> {
    E toEntity(D dto);

    D toDto(E entity);
}
