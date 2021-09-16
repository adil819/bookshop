package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    public Book addBook(Book book);
    public Book getBookById(String uuid);
    public List<Book> getBooks();
    public Book updateBook(String uuid, Book book);
    public void hardDeleteBook(String uuid);
    public Page<Book> getBookPerPage(Pageable pageable);
    List<Book> searchBookTitle(String title);
    public List<Book> getBookByYear();
    }
