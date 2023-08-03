package com.example.demo.service;
import com.example.demo.model.Book;

public interface BookService {
    Book createBook(Book book);

    Book updateBook(String id, Book book);

    void deleteBook(String id);

    Book getBookById(String id);
}
