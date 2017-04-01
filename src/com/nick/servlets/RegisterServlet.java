package com.nick.servlets;

import com.nick.java.UserDB;
import com.nick.jbcrypt.BCrypt;
import com.nick.utils.MessageUtils;
import com.nick.utils.StringUtils;

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
//        PhoneF = StringUtils.capitalizeFirstLetter(PhoneF);

        String EmailF = request.getParameter(Email);

        if (NameF!=null&&SurnameF!=null&&PhoneF!=null) {
            if (StringUtils.emailCheck(EmailF.trim())) {
                String PasswordF = request.getParameter(Password);
                String pw_hash = BCrypt.hashpw(PasswordF, BCrypt.gensalt());
                UserDB userDB = new UserDB();
                userDB.saveNewUser(EmailF, NameF, SurnameF, PhoneF, pw_hash);

                request.setAttribute("hello", MessageUtils.AFTER_REGISTER_MESSAGE);
                request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
            } else {
                request.setAttribute("name", NameF);
                request.setAttribute("surname", SurnameF);
                request.setAttribute("phone", PhoneF);
                request.setAttribute("emailErr", MessageUtils.REGISTER_ERROR_MESSAGE);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }else {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }


//        User user = new User(EmailF,NameF,SurnameF,PhoneF,pw_hash);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        EmailSender emailSender = new EmailSender();
//        emailSender.send("fetissov.n@gmail.com");
//        System.out.println("skjvbskjbv");
        request.getRequestDispatcher("/register.jsp").forward(request,response);

    }
}
