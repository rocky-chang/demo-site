package com.demosite.dao;

import org.springframework.stereotype.Component;

import com.demosite.bean.User;

@Component
public interface UserDao {

    //ユーザ登録
    int regist(String loginId,String password);

    //ユーザ検索
    User search(String loginId,String password);
}