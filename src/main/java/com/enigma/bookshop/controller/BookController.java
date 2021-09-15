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
    private String uuid;

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable String uuid){
        this.uuid = uuid;
        return bookService.getBookById(uuid);
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
//                                              @RequestParam(name="sortBy", defaultValue = "title") String direction,
//                                              @RequestParam(name="direction", defaultValue = "ASC") String sortBy){
//        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page,size);     // tanpa ,sort
        Page<Book> bookPage = bookService.getBookPerPage(pageable);
        return new PageResponseWrapper<>(bookPage);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable String uuid, @RequestBody Book book){
        return bookService.updateBook(uuid, book);
    }

    @DeleteMapping("/books/{id}")
    public void hardDeleteBook(@PathVariable String uuid){
        bookService.hardDeleteBook(uuid);
    }

}
