<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h3 {
            font-size: 20px;
            color: #000; 
            margin-top: 10px;
        }
        p {
            font-size: 16px;
            line-height: 1.6;
            margin-bottom: 20px;
            color: #000; 
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>
    <c:forEach items="${listNews}" var="x">
        <h3>Tiêu đề</h3>
        <p>${x.title}</p>
        <h3>Nội dung</h3>
        <p>${x.content}</p>
        <h3>Tác Giả</h3>
        <p>${x.author}</p>
    </c:forEach>
    <%@ include file="footer.jsp" %>
</body>
</html>
