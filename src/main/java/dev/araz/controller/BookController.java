package dev.araz.controller;

import dev.araz.entity.Book;
import dev.araz.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // add list books
    @PostMapping
    public void addBooks() {

    }

    // get all books
    @GetMapping
    public Flux<Book> getBooks() {
        return bookService.getBooks();
    }

    // get all free books
    @GetMapping("/free")
    public Flux<Book> getFreeBooks() {
        return bookService.getFreeBooks();
    }

    // search books by param
    @GetMapping("/search")
    public Flux<Book> searchBooks(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String author,
            @RequestParam(required = false, defaultValue = "") String publisher,
            @RequestParam(required = false, defaultValue = "") String yearEdition,
            @RequestParam(required = false, defaultValue = "") String translator,
            @RequestParam(required = false, defaultValue = "") String description
    ) {
        return bookService.search(name, author, publisher,
                                  yearEdition, translator, description);
    }
}