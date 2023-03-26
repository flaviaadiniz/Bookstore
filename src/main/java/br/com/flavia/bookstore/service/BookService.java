package br.com.flavia.bookstore.service;

import br.com.flavia.bookstore.model.Book;
import br.com.flavia.bookstore.model.Genre;
import br.com.flavia.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Iterable<Book> searchBook(
            String title, String authorLastName,String authorFirstName, String releaseYear, Genre genre,
            String isbn) {

        if (title != null && authorLastName == null && authorFirstName == null && releaseYear == null
                && genre == null && isbn == null) {
            return bookRepository.findBookByTitleContainingIgnoreCase(title);
        }

        if (title == null && authorLastName != null && authorFirstName == null && releaseYear == null
                && genre == null && isbn == null) {
            return bookRepository.findBookByAuthorLastNameContainingIgnoreCase(authorLastName);
        }

        if (title == null && authorLastName == null && authorFirstName != null && releaseYear == null
                && genre == null && isbn == null) {
            return bookRepository.findBookByAuthorFirstNameContainingIgnoreCase(authorFirstName);
        }

        if (title == null && authorLastName == null && authorFirstName == null && releaseYear != null
                && genre == null && isbn == null) {
            return bookRepository.findBookByReleaseYear(releaseYear);
        }

        if (title == null && authorLastName == null && authorFirstName == null && releaseYear == null
                && genre != null && isbn == null) {
            return bookRepository.findBookByGenre(genre);
        }

        if (title == null && authorLastName == null && authorFirstName == null && releaseYear == null
                && genre == null && isbn != null) {
            return bookRepository.findBookByIsbn(isbn);
        } else {
            System.out.println("No results");
            return new ArrayList<>();
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
        if (book.getAuthorFirstName() != null) {
            bookToUpdate.setAuthorFirstName(book.getAuthorFirstName());
        }
        if (book.getAuthorLastName() != null) {
            bookToUpdate.setAuthorLastName(book.getAuthorLastName());
        }
        if (book.getReleaseYear() != null) {
            bookToUpdate.setReleaseYear(book.getReleaseYear());
        }
        if (book.getGenre() != null) {
            bookToUpdate.setGenre(book.getGenre());
        }
        if (book.getIsbn() != null) {
            bookToUpdate.setIsbn(book.getIsbn());
        }
        if (book.getPages() != null) {
            bookToUpdate.setPages(book.getPages());
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
