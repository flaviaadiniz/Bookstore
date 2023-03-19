package br.com.flavia.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String releaseYear;

    private Genre genre;
}