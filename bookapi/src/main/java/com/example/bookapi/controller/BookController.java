package com.example.bookapi.controller;

import com.example.bookapi.entity.Book;
import com.example.bookapi.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping
    public List<Book> getAllBooks() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return service.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return service.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return service.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteById(id);
    }
}
