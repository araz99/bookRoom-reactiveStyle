package dev.araz.repository;

import dev.araz.entity.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
    @Query("SELECT * FROM book where busy = :busy")
    Flux<Book> findBooksByBusy(boolean busy);

    default Flux<Book> search(String query) {

        return Flux.empty();
    }
}