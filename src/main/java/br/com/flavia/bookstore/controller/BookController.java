package br.com.flavia.bookstore.controller;

import br.com.flavia.bookstore.model.Book;
import br.com.flavia.bookstore.model.Genre;
import br.com.flavia.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping
    public Iterable<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @GetMapping("/search")
    public Iterable<Book> searchBook(
            @RequestParam (name = "title", required = false) String title,
            @RequestParam (name = "author", required = false) String author,
            @RequestParam (name = "releaseYear", required = false) String releaseYear,
            @RequestParam (name = "genre", required = false) Genre genre
            ) {
        return bookService.searchBook(title, author, releaseYear, genre);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

}
