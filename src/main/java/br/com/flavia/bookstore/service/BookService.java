package br.com.flavia.bookstore.service;

import br.com.flavia.bookstore.model.Book;
import br.com.flavia.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Iterable<Book> findAll() {
            return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        if (bookRepository.existsById(id)) {
            return bookRepository.findById(id);
        } else {

            System.out.println("ID inexistente!");
            return Optional.empty();
        }
    }

    public Book updateBook(Long id, Book book) {
        Optional<Book> bookToUpdateOptional = bookRepository.findById(id);

        if (bookToUpdateOptional.isEmpty()) {
            System.out.println("ID inexistente!");
            return null;
        }

        Book bookToUpdate = bookToUpdateOptional.get();

        if (book.getTitle() != null) {
            bookToUpdate.setTitle(book.getTitle());
        }
        if (book.getAuthor() != null) {
            bookToUpdate.setAuthor(book.getAuthor());
        }
        if (book.getReleaseYear() != null) {
            bookToUpdate.setReleaseYear(book.getReleaseYear());
        }
        if (book.getGenre() != null) {
            bookToUpdate.setGenre(book.getGenre());
        }

        return bookRepository.save(bookToUpdate);
    }

    public void deleteById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            System.out.println("ID inexistente!");
        }
    }

}
