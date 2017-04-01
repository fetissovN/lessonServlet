package com.nick.java;

import com.nick.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate {
    public boolean checkLogin(String email,String pass) {
        Boolean check = false;
        ConnectionJDBC db = new ConnectionJDBC();
        db.init();
//        String pw_hash = BCrypt.hashpw("1341341", BCrypt.gensalt());
//        System.out.println(pw_hash);
        try {
            PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM users WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
//                User user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("surname"),rs.getString("email"),rs.getString("phone"));
//                System.out.println(user);
                if (BCrypt.checkpw(pass, rs.getString("password"))) {
                    System.out.println("It matches");
                    check=true;
                }else {
                    System.out.println("It does not match");

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        String pw_hash = BCrypt.hashpw(nameS, BCrypt.gensalt());
//        System.out.println(pw_hash);
        return check;
    }

}
