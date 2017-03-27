package com.belhard.java;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public User getUserByEmail(String email){
        User user = null;
        try {
            connectionJDBC.init();
            PreparedStatement preparedStatement = connectionJDBC.getConnection().prepareStatement("SELECT * FROM users WHERE email=?");
            preparedStatement.setString(1,email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                user = new User(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("surname"),resultSet.getString("email"),resultSet.getString("phone"));
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connectionJDBC.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
