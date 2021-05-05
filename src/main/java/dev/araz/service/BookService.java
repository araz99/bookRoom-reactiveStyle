package dev.araz.service;

import dev.araz.entity.Book;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public interface BookService {

    Flux<Book> getBooks();

    Flux<Book> getFreeBooks();

    Flux<Book> search(String name, String author, String publisher, String yearEdition, String translator, String description);
}
