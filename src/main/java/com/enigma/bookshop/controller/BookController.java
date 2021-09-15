package com.enigma.bookshop.controller;

import com.enigma.bookshop.entity.Book;
import com.enigma.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @GetMapping("/books")
//    public List<Book> getBookById(@RequestParam Integer page){
//        return bookService.getBooksPage(1)
//    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    public void hardDeleteBook(@PathVariable Integer id){
        bookService.hardDeleteBook(id);
    }

}
