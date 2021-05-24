package dev.araz.controller;

import dev.araz.dto.BookDto;
import dev.araz.entity.Book;
import dev.araz.mapper.MapperDto;
import dev.araz.repository.BookRepository;
import dev.araz.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;
    private final MapperDto<Book, BookDto> mapper;

    // add list books
    @PostMapping
    public Flux<BookDto> addBooks(@RequestBody List<BookDto> dtoList) {
        return bookRepository
                .saveAll(dtoList.stream().map(mapper::toEntity).collect(Collectors.toList()))
                .map(mapper::toDto);
    }

    // get all books
    @GetMapping
    public Flux<BookDto> getBooks() {
        return bookService.getBooks();
    }

    // get all free books
    @GetMapping("/free")
    public Flux<BookDto> getFreeBooks() {
        return bookService.getFreeBooks();
    }

    // search books by param
    @GetMapping("/search")
    public Flux<BookDto> searchBooks(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false) String yearEdition,
            @RequestParam(required = false) String translator,
            @RequestParam(required = false) String description
    ) {
        return bookService
                .search(name, author, publisher,yearEdition, translator, description);
    }
}