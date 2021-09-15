package com.enigma.bookshop.controller;

import com.enigma.bookshop.entity.Book;
import com.enigma.bookshop.service.BookService;
import com.enigma.bookshop.utils.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

//    @GetMapping("/books")
//    public List<Book> getBookById(@RequestParam Integer page){
//        return bookService.getBooksPage(1)
//    }

//    @GetMapping("/books")
//    public List<Book> getBooks(){
//        return bookService.getBooks();
//    }
    @GetMapping("/books")
    public PageResponseWrapper<Book> getBookPerPage(@RequestParam(name="page", defaultValue = "0") Integer page,
                                              @RequestParam(name="size", defaultValue = "3") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Book> bookPage = bookService.getBookPerPage(pageable);
        return new PageResponseWrapper<>(bookPage);
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
