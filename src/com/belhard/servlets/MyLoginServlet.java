package com.belhard.servlets;

import com.belhard.java.UserDB;
import com.belhard.java.Validate;
import com.belhard.utils.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Николай on 24.03.2017.
 */
public class MyLoginServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
//            response.setContentType("text/html");
//            response.setCharacterEncoding("UTF-8");
//
//
//            PrintWriter out = response.getWriter();
//
//            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
//            out.println("<title>Hello Page</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<center>");
//            out.println("<h1>Hello Page</h1>");
//            out.println("</center>");
//            out.println("<h1>Hello," + nameUser + "</h1>");
//            out.println("<a href=\"" + request.getServletContext().getContextPath() + "/index.jsp\">Go To Index Page</a>");
        }else {
            request.setAttribute("wrongLogin", StringUtils.LOGIN_ERROR_MESSAGE);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
//     response.sendRedirect("index.jsp");
        }

    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
