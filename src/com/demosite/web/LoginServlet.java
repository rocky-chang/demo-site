package com.demosite.web;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.demosite.bean.User;
import com.demosite.service.UserService;

public class LoginServlet extends javax.servlet.http.HttpServlet{

    private static final long serialVersionUID =1L;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        // ユーザ情報を取得
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");

        UserService userService = (UserService) context.getBean("userService");

        User user = userService.search(loginId, password);
        request.setAttribute("user",user);

        if(user==null){
        	request.setAttribute("message", "ログインIDまたはパスワードが存在しない。");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("hello.jsp").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
