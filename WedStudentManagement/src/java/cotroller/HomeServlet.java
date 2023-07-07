/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cotroller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home", "/search", "/delete", "/logout", "/addform"})
public class HomeServlet extends HttpServlet {

    List<Student> studentList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        studentList = (List<Student>) request.getSession().getAttribute("studentList");
        processRequest(request, response);

        String action;
        if (uri.endsWith("/home")) {
            action = "home";
        } else if (uri.endsWith("/search")) {
            action = "search";
        } else if (uri.endsWith("/logout")) {
            action = "logout";
        } else if (uri.endsWith("/addform")) {
            action = "addform";
        } else {
            action = "unknown";
        }
        switch (action) {
            case "home":
                studentList = (List<Student>) request.getSession().getAttribute("studentList");
                int currentPage = 1;
                String pageParam = request.getParameter("page");
                if (pageParam != null) {
                    currentPage = Integer.parseInt(pageParam);
                }
                int startIndex = (currentPage - 1) * 5;
                int endIndex = Math.min(startIndex + 5, studentList.size());

                List<Student> studentsOnPage = studentList.subList(startIndex, endIndex);
                int totalPages = (int) Math.ceil((double) studentList.size() / 5);

                request.setAttribute("students", studentsOnPage);
                request.setAttribute("currentPage", currentPage);
                request.setAttribute("totalPages", totalPages);
                request.getRequestDispatcher("home.jsp").forward(request, response);

                return;
            case "search":
                List<Student> filteredList = new ArrayList<>();

                String searchKeyword = request.getParameter("search");
                if (searchKeyword != null && !searchKeyword.isEmpty()) {
                    for (Student student : studentList) {
                        if (student.getName().toLowerCase().contains(searchKeyword.toLowerCase())) {
                            filteredList.add(student);
                        } else {
                            request.setAttribute("notFound", true);
                        }

                    }

                } else {
                    filteredList = studentList;
                    request.setAttribute("notFound", true);
                }

                if (!filteredList.isEmpty()) {
                    request.setAttribute("students", filteredList);
                }

                request.getRequestDispatcher("home.jsp").forward(request, response);
                return;
            case "logout":
                response.sendRedirect("login");
                return;
            case "addform":
                request.setAttribute("students", studentList);
                response.sendRedirect("add");
                return;

            default:

                return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        studentList = (List<Student>) request.getSession().getAttribute("studentList");

        String deleteKey = request.getParameter("delete");
        if (deleteKey != null && !deleteKey.isEmpty()) {
            if (studentList != null) {
                Iterator<Student> iterator = studentList.iterator();
                while (iterator.hasNext()) {
                    Student student = iterator.next();
                    if (student.getName().toLowerCase().contains(deleteKey.toLowerCase())) {
                        iterator.remove();
                    }
                }
            }
        }

        saveStudentList();
        response.sendRedirect("home");
    }

    private void saveStudentList() {
        JSONArray jsonArray = new JSONArray();
        for (Student student : studentList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", student.getName());
            jsonObject.put("id", student.getId());
            jsonObject.put("password", student.getPassword());
            jsonObject.put("email", student.getEmail());
            jsonObject.put("phone", student.getPhone());
            jsonObject.put("address", student.getAddress());
            jsonObject.put("gender", student.getGender());
            jsonObject.put("createdAt", student.getCreatedAt());
            jsonArray.add(jsonObject);
        }

        try ( FileWriter fileWriter = new FileWriter("E:\\PRJ301\\WedStudentManagement\\src\\java\\model\\student.json")) {
            fileWriter.write(jsonArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getSession().getAttribute("name");
        request.setAttribute("name", name);
    }
}
