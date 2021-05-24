package dev.araz.dto;

import lombok.Data;

@Data
public class BookDto {
    private String name;
    private String author;
    private String publisher;
    private int yearEdition;
    private String translator;
    private String description;
    private boolean busy;
}
