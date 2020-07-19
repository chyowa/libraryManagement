package com.example.book.service.impl;

import com.example.book.pojo.Users;
import com.example.book.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private com.example.book.dao.UsersDao usersDao;

    public Users dologin(String username, String password) {
        return this.usersDao.login(username,password);
    }
}
