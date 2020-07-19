package com.example.book.dao;

import com.example.book.pojo.Books;

import java.util.List;

public interface BooksDao {

    List<Books> getBooks();
    Books preUpdateBook(int bookId);
    void updateBook(Books book);
    void addBook(Books book);
    void deleteBook(int bookId);
}
