package com.example.book.dao;

import com.example.book.pojo.Users;

public interface UsersDao {

    Users login(String username, String password);
}
