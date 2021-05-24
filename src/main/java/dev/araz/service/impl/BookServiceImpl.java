package dev.araz.service.impl;

import dev.araz.dto.BookDto;
import dev.araz.entity.Book;
import dev.araz.mapper.MapperDto;
import dev.araz.repository.BookRepository;
import dev.araz.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final MapperDto<Book, BookDto> mapper;

    @Override
    public Flux<BookDto> getBooks() {
        return bookRepository.findAll().map(mapper::toDto);
    }

    @Override
    public Flux<BookDto> getFreeBooks() {
        return bookRepository.findBooksByBusy(false).map(mapper::toDto);
    }

    @Override
    public Flux<BookDto> search(String name, String author, String publisher, String yearEdition, String translator, String description) {
        String params = name + author + publisher + yearEdition + translator + description;
        if (params == null)
            return bookRepository.findAll().map(mapper::toDto);
        else
            return bookRepository.search(createQuery(name, author, publisher, yearEdition, translator, description))
                    .map(mapper::toDto);

    }

    private static String createQuery(String name, String author, String publisher, String yearEdition, String translator, String description) {
        String query = "SELECT * FROM book where";

        if (name != null)
            query += " and name=" + name;
        if (author != null)
            query += " and author=" + author;
        if (publisher != null)
            query += " and publisher=" + publisher;
        if (yearEdition != null)
            query += " and yearEdition=" + yearEdition;
        if (translator != null)
            query += " and translator=" + translator;
        if (description != null)
            query += " and description=" + description;

        query = query.replaceFirst("and", "");

        return query;
    }
}