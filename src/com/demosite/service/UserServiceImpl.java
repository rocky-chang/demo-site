package com.demosite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demosite.bean.User;
import com.demosite.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao ;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //ユーザ登録
    @Override
    public int regist(String loginId, String password) {
        return userDao.regist(loginId,password);
    }

    ////ユーザ検索
    @Override
    public User search(String loginId, String password) {
        return userDao.search(loginId,password);
    }
}