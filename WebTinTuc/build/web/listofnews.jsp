<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <style>
       
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        .content {
            margin: 20px;
        }
    </style>
</head>
<html>
    <body>
        <%@ include file="header.jsp" %>
        <div class="content">
            <h2 style="font-size: 50px">Danh sách tin tức</h2>
            <p style="font-size: 30px">Tổng tin tức hiện có</p>

        
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tiêu đề</th>
                        <th>Nội dung</th>
                        <th>Tác giả</th>
                        <th>Lượt xem</th>
                        <th>Ngày tạo</th>
                        <th>Xem chi tiết</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listNews}" var="x">
                        <tr>
                            <td>${x.ID}</td>
                            <td>${x.title}</td>
                            <td>${x.content.substring(0, 50)}...</td> 
                            <td>${x.author}</td>
                            <td>${x.views}</td>
                            <td>${x.createdDate}</td>
                            <td><a href="show?id=${x.ID}">Xem chi tiết</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
    <%@ include file="footer.jsp" %>
</html>
