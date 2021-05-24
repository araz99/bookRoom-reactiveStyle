package dev.araz.service;

import dev.araz.dto.BookDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public interface BookService {

    Flux<BookDto> getBooks();

    Flux<BookDto> getFreeBooks();

    Flux<BookDto> search(String name, String author, String publisher, String yearEdition, String translator, String description);
}
