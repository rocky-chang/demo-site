package com.demosite.service;

import org.springframework.stereotype.Service;

import com.demosite.bean.User;

@Service
public interface UserService {

    //ユーザ登録
    int regist(String loginId,String password);

    //ユーザ検索
    User search(String loginId,String password);

}
