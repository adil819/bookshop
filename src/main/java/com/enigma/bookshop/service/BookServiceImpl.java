package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Book;
import com.enigma.bookshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).get();
    }
}
