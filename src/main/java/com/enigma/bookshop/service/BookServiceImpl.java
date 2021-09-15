package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Book;
import com.enigma.bookshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(String uuid) {
        return bookRepository.findById(uuid).get();
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(String uuid, Book book) {
        Book book_update = bookRepository.findById(uuid).get();
        if(book_update != null) {
            book_update = book;
            book_update.setUuid(uuid);
            return bookRepository.save(book);
        } else {
            return null;
        }

    }

    @Override
    public void hardDeleteBook(String uuid) {
        bookRepository.deleteById(uuid);
    }

    @Override
    public Page<Book> getBookPerPage(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
}

