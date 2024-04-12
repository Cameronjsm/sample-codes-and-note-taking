/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package twitter;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author Cameron Mosley
 */
public class usermodel {
    
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
        Connection connection = DatabaseConnection.getConnection();
   
        Statement statement = connection.createStatement();
        
        ResultSet results = statement.executeQuery("select * from user");
        
        while (results.next()) {
            int id = results.getInt("id");
            String username = results.getString("username");
            String password =results.getString("password");
            
            User user = new User(id, username, password);
            
            users.add(user);
        }
        results.close();
        statement.close();
        connection.close();
        }

    catch ( Exception ex) {
        System.out.println(ex);
    }
  
        
          return users;
    }

    public static void addUser (User user){
     try {
        Connection connection = DatabaseConnection.getConnection();
   
       String query = "insert into user (username, password )"
               + "values (?, ?)";
        
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        
        statement.execute();
        
        statement.close();
        connection.close();
        }

    catch ( Exception ex) {
        System.out.println(ex);
    }   
    }

}
