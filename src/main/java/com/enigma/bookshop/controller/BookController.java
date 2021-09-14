package com.enigma.bookshop.controller;

import com.enigma.bookshop.entity.Book;
import com.enigma.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    BookService bookService;
    private Integer id;

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Integer id){
        this.id = id;
        return bookService.getBookById(id);
    }

}
