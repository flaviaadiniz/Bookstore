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

    @Column(unique = true)
    private String isbn;

    private String title;

    private String authorLastName;

    private String authorFirstName;

    private String releaseYear;

    private Integer pages;

    @Enumerated(EnumType.STRING)
    private Genre genre;
}