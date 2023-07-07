/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cotroller;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
@WebServlet(name = "AddServlet", urlPatterns = {"/add"})
public class AddServlet extends HttpServlet {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    List<Student> studentList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        request.getRequestDispatcher("add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        studentList = (List<Student>) request.getSession().getAttribute("studentList");

        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        LocalDateTime dateTime = LocalDateTime.now();
        String createdAt = dateTime.format(formatter);

        Student newStudent = new Student(name, id, password, email, phone, address, gender, createdAt);

        studentList.add(newStudent);
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.getCreatedAt().compareTo(s1.getCreatedAt());
            }
        });
        String successMessage = "Student created successfully";
        request.setAttribute("successMessage", successMessage);

        response.sendRedirect("home?successMessage=" + successMessage);
        request.getSession().setAttribute("studentList", studentList);
        saveStudentList();

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getSession().getAttribute("name");
        request.setAttribute("name", name);

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
}
