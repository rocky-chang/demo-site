package com.demosite.web;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.demosite.service.UserService;

public class RegistServlet extends javax.servlet.http.HttpServlet{

    private static final long serialVersionUID =1L;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        // ユーザ情報を登録
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");

        UserService userService = (UserService) context.getBean("userService");

        int result = userService.regist(loginId, password);

        if(result > 0){
        	request.setAttribute("message", "ログインID登録完了しました。");
        }else{
        	request.setAttribute("message", "ログインID登録失敗しました。");
        }
        request.getRequestDispatcher("regist.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
