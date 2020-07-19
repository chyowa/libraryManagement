package com.example.book.service;

import com.example.book.pojo.Books;

import java.util.List;

public interface BooksService {

    List<Books> getBooks();
    Books preUpdateBook(int bookId);
    void updateBook(Books book);
    void addBook(Books book);
    void deleteBook(int bookId);
}
