/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package twitter;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cameron Mosley
 */
public class twitter extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if ( action == null) {
            action = "listUsers";
        }
        
        if  (action.equalsIgnoreCase("listUsers")) {
            
        
        
        ArrayList<User> user = usermodel.getUsers();
        
        

//users the object is referencing users the ArrayList 
        request.setAttribute("users", user);        
        String url = "/users.jsp";
        getServletContext().getRequestDispatcher(url).forward(request,response);
        } else if (action.equalsIgnoreCase("createUser")) {
          String username =  request.getParameter("username");
          String password = request.getParameter("password");
          
          if (username == null || password == null) {
              String error = "username or password missing";
          String url = "/error.jsp";
              getServletContext().getRequestDispatcher(url).forward(request,response);
          }
          
          try {
          
          String hashedPassword = toHexString (getSHA(password));
          
          
          User user = new User(0, username, hashedPassword);
          
          usermodel.addUser(user);
          
          response.sendRedirect("Twitter");
          
          }
          catch (Exception ex) {
              System.out.println(ex);
          }
    }
    }
public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");
 
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
     
    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);
 
        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
 
        // Pad with leading zeros
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }
 
        return hexString.toString();
    }
}
