package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Book;

import java.util.List;

public interface BookService {
    public Book addBook(Book book);
    public Book getBookById(Integer id);
    public List<Book> getBooks();
    public Book updateBook(Integer id, Book book);
    public void hardDeleteBook(Integer id);
}
