<%@page import="model.Student"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>List of Students</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
            }
            .pagination {
                margin-top: 10px;
            }

            .pagination a {
                display: inline-block;
                padding: 5px 10px;
                margin-right: 5px;
                color: #000;
                text-decoration: none;
                border: 1px solid #ddd;
                border-radius: 4px;
            }

            .pagination a.active {
                background-color: #4CAF50;
                color: #fff;
                border: 1px solid #4CAF50;
            }

            .success-message {
                background-color: #4CAF50;
                color: #fff;
                padding: 10px;
                margin-bottom: 10px;
            }

            .container {
                max-width: 800px;
                margin: 0 auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);
            }

            .header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-bottom: 20px;
            }

            .logout-btn {
                padding: 10px 20px;
                background-color: #f44336;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            .form-title {
                font-size: 20px;
                margin-bottom: 10px;
            }

            .table-container {
                margin-bottom: 20px;
            }

            table {
                width: 100%;
                border-collapse: collapse;
            }

            th, td {
                padding: 10px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            th {
                background-color: #f2f2f2;
            }

            .search-bar {
                display: flex;
                align-items: center;
                margin-bottom: 10px;
            }

            .search-input {
                flex: 1;
                padding: 5px;
                border-radius: 4px;
                border: 1px solid #ccc;
            }

            .search-btn {
                padding: 5px 10px;
                background-color: #4CAF50;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                margin-left: 10px;
            }

            .button-group {
                display: flex;
                justify-content: flex-end;
                margin-bottom: 10px;
            }

            .delete-btn, .add-btn {
                padding: 10px 20px;
                background-color: #f44336;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                margin-left: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="user-info">
                    <% String successMessage = request.getParameter("successMessage");
                        if (successMessage != null && !successMessage.isEmpty()) {%>
                    <div class="success-message">
                        <%= successMessage%>
                    </div>
                    <% }%>

                    <span>Welcome <%= request.getAttribute("name")%></span>
                </div>
                <form method="get" action="logout">
                    <button class="logout-btn">Logout</button>
                </form>

            </div>

            <h2 class="form-title">List of Students</h2>
            <% if (request.getAttribute("notFound") != null) { %>
            <p>No results found.</p>
            <% } %>
            <form method="get" action="search">
                <div class="search-bar">
                    <input type="text" class="search-input" name="search" placeholder="Search..." value="${param.search}" />
                    <button class="search-btn">Search</button>
                </div>
            </form>
            <form method="get" action="home" >
                <div class="table-container">

                    <table>
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>ID</th>
                                <th>Password</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Gender</th>
                                <th>Created At</th>
                            </tr>
                        </thead>
                        <tbody>

                            <% if (request.getAttribute("students") != null) {
                                    for (Student student : (List<Student>) request.getAttribute("students")) {%>
                            <tr>
                                <td><%= student.getName()%></td>
                                <td ><%= student.getId()%></td>
                                <td><%= student.getPassword()%></td>
                                <td><%= student.getEmail()%></td>
                                <td><%= student.getPhone()%></td>
                                <td><%= student.getAddress()%></td>
                                <td><%= student.getGender()%></td>
                                <td><%= student.getCreatedAt()%></td>
                            </tr>
                            <%  }
                                }%>


                        </tbody>

                    </table>
                    <div class="pagination">
                        <ul>
                            <% int totalPages = (int) request.getAttribute("totalPages");
                                int currentPage = (int) request.getAttribute("currentPage");
                                for (int i = 1; i <= totalPages; i++) {
                                    String activeClass = (i == currentPage) ? "active" : "";
                            %>
                            <li class="<%= activeClass%>">
                                <a href="home?page=<%= i%>"><%= i%></a>
                            </li>
                            <% }%>
                        </ul>
                    </div>


                </div>

            </form>
            <div class="button-group">
                <div class="button-group">
                    <form method="post" action="delete">
                        <div class="search-bar">
                            <input type="text" class="search-input" name="delete" placeholder="Search..." value="${param.delete}" />
                            <button class="search-btn">Delete</button>
                        </div>
                    </form>
                </div>
                <form method="get" action="addform" >
                    <button class="add-btn">Add</button>
                </form>

            </div>
        </div>
    </body>
</html>
