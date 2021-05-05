package dev.araz.service.impl;

import dev.araz.entity.Book;
import dev.araz.repository.BookRepository;
import dev.araz.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Flux<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Flux<Book> getFreeBooks() {
        return bookRepository.findByBusy(false);
    }

    @Override
    public Flux<Book> search(String name, String author, String publisher, String yearEdition, String translator, String description) {
        return bookRepository.findAll();
    }
}
