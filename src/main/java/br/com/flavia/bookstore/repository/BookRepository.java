package br.com.flavia.bookstore.repository;

import br.com.flavia.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
