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

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String releaseYear;

    @Column(nullable = false)
    private Genre genre;
}
