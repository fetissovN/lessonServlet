package com.belhard.java;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDB {
    ConnectionJDBC connectionJDBC = new ConnectionJDBC();
    public void saveNewUser(String email, String name, String surname, String phone, String password){

        try {
            connectionJDBC.init();
            PreparedStatement preparedStatement = connectionJDBC.getConnection().prepareStatement("INSERT INTO users (email,name,surname,phone,password) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,surname);
            preparedStatement.setString(4,phone);
            preparedStatement.setString(5,password);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connectionJDBC.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
