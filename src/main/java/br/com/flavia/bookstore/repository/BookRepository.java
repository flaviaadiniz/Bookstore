package br.com.flavia.bookstore.repository;

import br.com.flavia.bookstore.model.Book;
import br.com.flavia.bookstore.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    Iterable<Book> findBookByTitleContainingIgnoreCase(String title);
    Iterable<Book> findBookByAuthorLastNameContainingIgnoreCase(String authorLastName);
    Iterable<Book> findBookByAuthorFirstNameContainingIgnoreCase(String authorFirstName);
    Iterable<Book> findBookByReleaseYear(String releaseYear);
    Iterable<Book> findBookByGenre(Genre genre);
    Iterable<Book> findBookByIsbn(String isbn);}
