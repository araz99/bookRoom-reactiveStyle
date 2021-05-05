package dev.araz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Book {
    @Id
    private Long id;
    private String name;
    private String author;
    private String publisher;
    private int yearEdition;
    private String translator;
    private String description;
    private boolean busy;
}
