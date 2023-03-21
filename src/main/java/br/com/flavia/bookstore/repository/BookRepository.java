package br.com.flavia.bookstore.repository;

import br.com.flavia.bookstore.model.Book;
import br.com.flavia.bookstore.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    Iterable<Book> findBookByTitleContainingIgnoreCase(String title);
    Iterable<Book> findBookByAuthorContainingIgnoreCase(String author);
    Iterable<Book> findBookByReleaseYear(String releaseYear);
    Iterable<Book> findBookByGenre(Genre genre);

}
