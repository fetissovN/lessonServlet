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
    private static final String email = "txt_first_name";

    private static final String pass = "txt_last_name";

    private static final String email_default = "NoName";

    private static final String pass_default = "NoName";
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String emailName = request.getParameter(email);
        if (StringUtils.isBlank(emailName)) {
            emailName = email_default;
        }
//        emailName = StringUtils.capitalizeFirstLetter(emailName);

        String password = request.getParameter(pass);
        if (StringUtils.isBlank(password)) {
            password = pass_default;
        }
        String nameUser = new UserDB().getUserByEmail(emailName).getName();
        System.out.println(nameUser);
//        password = StringUtils.capitalizeFirstLetter(password);
        if (new Validate().checkLogin(emailName,password)){
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");


            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<title>Hello Page</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Hello Page</h1>");
            out.println("</center>");
            out.println("<h1>Hello," + nameUser + "</h1>");
            out.println("<a href=\"" + request.getServletContext().getContextPath() + "/index.html\">Go To Index Page</a>");
        }else {
            response.sendRedirect("index.html");
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
