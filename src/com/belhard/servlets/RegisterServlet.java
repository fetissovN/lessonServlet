package com.belhard.servlets;

import com.belhard.java.EmailSender;
import com.belhard.java.User;
import com.belhard.java.UserDB;
import com.belhard.jbcrypt.BCrypt;
import com.belhard.utils.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/register")
public class RegisterServlet extends HttpServlet {
    private static final String Name = "name";
    private static final String Surname = "surname";
    private static final String Phone = "phone";
    private static final String Email = "email";
    private static final String Password = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        TODO counter of users before
        String NameF = request.getParameter(Name);
        NameF = StringUtils.capitalizeFirstLetter(NameF);

        String SurnameF = request.getParameter(Surname);
        SurnameF = StringUtils.capitalizeFirstLetter(SurnameF);

        String PhoneF = request.getParameter(Phone);
        PhoneF = StringUtils.capitalizeFirstLetter(PhoneF);

        String EmailF = request.getParameter(Email);
        EmailF = StringUtils.capitalizeFirstLetter(EmailF);

        String PasswordF = request.getParameter(Password);
//        PasswordF = StringUtils.capitalizeFirstLetter(PasswordF);
        String pw_hash = BCrypt.hashpw(PasswordF, BCrypt.gensalt());
        UserDB userDB = new UserDB();
        userDB.saveNewUser(EmailF,NameF,SurnameF,PhoneF,pw_hash);
        response.sendRedirect("/");
//        User user = new User(EmailF,NameF,SurnameF,PhoneF,pw_hash);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        EmailSender emailSender = new EmailSender();
//        emailSender.send("fetissov.n@gmail.com");
//        System.out.println("skjvbskjbv");
        request.getRequestDispatcher("/register.jsp").forward(request,response);

    }
}
