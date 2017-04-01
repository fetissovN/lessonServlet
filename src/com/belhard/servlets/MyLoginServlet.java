package com.belhard.servlets;

import com.belhard.java.UserDB;
import com.belhard.java.Validate;
import com.belhard.utils.MessageUtils;
import com.belhard.utils.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MyLoginServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String emailName = request.getParameter(StringUtils.EMAIL);
        if (StringUtils.isBlank(emailName)) {
            emailName = StringUtils.EMAIL_DEFAULT;
        }


        String password = request.getParameter(StringUtils.PASS);
        if (StringUtils.isBlank(password)) {
            password = StringUtils.PASS_DEFAULT;
        }
//        String nameUser = new UserDB().getUserByEmail(emailName).getName();
//        System.out.println(nameUser);

        if (new Validate().checkLogin(emailName,password)){
            request.setAttribute("name",new UserDB().getUserByEmail(emailName).getName());
            request.getRequestDispatcher("/welcome.do.jsp").forward(request,response);
        }else{
            request.setAttribute("wrongLogin", MessageUtils.LOGIN_ERROR_MESSAGE);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//
//        String emailName = request.getParameter(StringUtils.EMAIL);
//        if (StringUtils.isBlank(emailName)) {
//            emailName = StringUtils.EMAIL_DEFAULT;
//        }
//
//
//        String password = request.getParameter(StringUtils.PASS);
//        if (StringUtils.isBlank(password)) {
//            password = StringUtils.PASS_DEFAULT;
//        }
////        String nameUser = new UserDB().getUserByEmail(emailName).getName();
////        System.out.println(nameUser);
//
//        if (new Validate().checkLogin(emailName,password)){
//            request.setAttribute("name",new UserDB().getUserByEmail(emailName).getName());
//            request.getRequestDispatcher("/welcome.do.jsp").forward(request,response);
//        }else{
//            request.setAttribute("wrongLogin", MessageUtils.LOGIN_ERROR_MESSAGE);
//            request.getRequestDispatcher("/index.jsp").forward(request,response);
//        }
//
//    }
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//    }
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//    }
//
//    @Override
//    public void destroy() {
//        super.destroy();
//    }
}
