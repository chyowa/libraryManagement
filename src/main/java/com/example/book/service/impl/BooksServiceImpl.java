package com.example.book.service.impl;

import com.example.book.dao.BooksDao;
import com.example.book.pojo.Books;
import com.example.book.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksDao booksDao;

    public List<Books> getBooks() {
        return this.booksDao.getBooks();
    }

    public Books preUpdateBook(int bookId){
        return this.booksDao.preUpdateBook(bookId);
    }


    public void updateBook(Books book){
        this.booksDao.updateBook(book);
    }


    public void addBook(Books book){
        this.booksDao.addBook(book);
    }

    public void deleteBook(int bookId){
        this.booksDao.deleteBook(bookId);
    }
}
