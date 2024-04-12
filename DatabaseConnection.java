/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package twitter;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author Cameron Mosley
 */
public class DatabaseConnection {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        String dbURL = "jdbc:mysql://localhost:3306/twitter_lessonexample";

        String username = "twitter_lessonexample";
        String password = "test";
        Connection connection = DriverManager.getConnection(
                dbURL, username, password);
        return connection;

    }
}