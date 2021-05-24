package dev.araz.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.araz.dto.BookDto;
import dev.araz.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapper<E, D> implements MapperDto<Book, BookDto> {

    private final ObjectMapper mapper;

    @Override
    public Book toEntity(BookDto dto) {
        return mapper.convertValue(dto, Book.class);
    }

    @Override
    public BookDto toDto(Book entity) {
        return mapper.convertValue(entity, BookDto.class);
    }
}
