package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Book;

public interface BookService {
    public Book addBook(Book book);
    public Book getBookById(Integer id);
}
