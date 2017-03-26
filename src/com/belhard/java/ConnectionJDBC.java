package com.belhard.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    final String url = "jdbc:mysql://localhost:3306/servlet_app?autoReconnect=true&useSSL=false";
    String userName = "root";
    String password = "root";
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public ConnectionJDBC() {

    }

    public void closeConnection() throws SQLException{
        connection.close();
    }

    public void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(url,userName,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
