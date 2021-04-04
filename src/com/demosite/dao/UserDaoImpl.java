package com.demosite.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.demosite.bean.User;

@Component
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //ユーザ登録
    @Override
    public int regist(String loginId, String password) {
        String sql = "insert into tb_user(loginId, password) values(?, ?)";
        int result = jdbcTemplate.update(sql, loginId, password);

        return result;
    }

    //ユーザ検索
    @Override
    public User search(String loginId, String password) {
        String sql = "select * from tb_user where loginId=? and password=?";

        BeanPropertyRowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);
        User user = null;
        user = jdbcTemplate.queryForObject(sql, mapper, loginId, password);
        user = new User(loginId, password);

        return user;
    }
}
