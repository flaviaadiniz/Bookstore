package br.com.flavia.bookstore.repository;

import br.com.flavia.bookstore.model.Book;
import br.com.flavia.bookstore.model.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    Iterable<Book> findBookByTitle(String title);
    Iterable<Book> findBookByAuthor(String author);
    Iterable<Book> findBookByReleaseYear(String releaseYear);
    Iterable<Book> findBookByGenre(Genre genre);

    @Query("SELECT b FROM Book b WHERE b.title LIKE '%titleContains%' ")
    Iterable<Book> findBookByTitleIsContainingIgnoreCase(String titleContains);

}
