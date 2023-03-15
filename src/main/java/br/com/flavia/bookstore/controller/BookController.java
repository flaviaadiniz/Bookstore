package br.com.flavia.bookstore.controller;

import br.com.flavia.bookstore.model.Book;
import br.com.flavia.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

}
