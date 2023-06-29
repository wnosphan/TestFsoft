/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "CheckLoginServlet", urlPatterns = {"/checklogin"})
public class CheckLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


private List<User> readUserList() {
    List<User> userList = new ArrayList<>();
    JSONParser parser = new JSONParser();

    try {
        // Change the path to your JSON file
        InputStream inputStream = new FileInputStream("E:\\PRJ301\\Servlet_Page_Form\\src\\java\\model\\users.json");
        
        // Parse the JSON file using the parser
        JSONArray jsonArray = (JSONArray) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        
        // Iterate over the JSON array and create User objects
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            int id = Integer.parseInt(jsonObject.get("id").toString());
            String username = (String) jsonObject.get("username");
            String password = (String) jsonObject.get("password");
            userList.add(new User(id, username, password));
        }
        
        // Close the input stream
        inputStream.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return userList;
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
  if (isValidLogin(username, password)) {
            response.sendRedirect("result?status=success");
        } else {
            response.sendRedirect("result?status=fail");
        }    

    
       
    }
   private boolean isValidLogin(String username, String password) {
        // Đọc danh sách người dùng từ file users.json
        List<User> userList = readUserList();
        
        // Kiểm tra thông tin đăng nhập
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
    return false;
   }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
