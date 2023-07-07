package cotroller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
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
import org.json.simple.parser.JSONParser;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/login", "/checklogin"})
public class LoginServlet extends HttpServlet {

    List<Student> studentList = readStudentList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.html").forward(request, response);
    }

    public List<Student> readStudentList() {
        List<Student> studentList = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            // Parse the JSON file using the parser
            try ( // Change the path to your JSON file
                     InputStream inputStream = new FileInputStream("E:\\PRJ301\\WedStudentManagement\\src\\java\\model\\student.json")) {
                // Parse the JSON file using the parser
                JSONArray jsonArray = (JSONArray) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                // Iterate over the JSON array and create User objects
                for (Object obj : jsonArray) {
                    JSONObject jsonObject = (JSONObject) obj;

                    String name = (String) jsonObject.get("name");
                    String id = (String) jsonObject.get("id");
                    String password = (String) jsonObject.get("password");
                    String email = (String) jsonObject.get("email");
                    String phone = (String) jsonObject.get("phone");
                    String address = (String) jsonObject.get("address");
                    String gender = (String) jsonObject.get("gender");
                    String createdAt = (String) jsonObject.get("createdAt");

                    studentList.add(new Student(name, id, password, email, phone, address, gender, createdAt));
                }
                // Close the input stream
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.getCreatedAt().compareTo(s1.getCreatedAt());
            }
        });

        return studentList;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if (isValidLogin(id, password)) {
            String name = findName(id);

            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("studentList", this.studentList);
            response.sendRedirect("home");

        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
            out.println("function goBack() {");
            out.println("  window.history.back();");
            out.println("}");
            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script>");
            out.println("alert('Invalid username or password. Please try again.');");
            out.println("goBack();");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    private String findName(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student.getName();
            }
        }
        return null;

    }

    private boolean isValidLogin(String id, String password) {
        // Đọc danh sách người dùng từ file users.json

        // Kiểm tra thông tin đăng nhập
        for (Student student : studentList) {
            if (student.getId().equals(id) && student.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
