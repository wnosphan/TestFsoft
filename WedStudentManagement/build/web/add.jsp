<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Student</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <style>body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
            }
            .ok-button {
                padding: 5px 10px;
                background-color: #4CAF50;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                margin-left: 10px;
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

            .form-group {
                margin-bottom: 10px;
            }

            label {
                display: block;
                font-weight: bold;
            }

            input, select {
                width: 100%;
                padding: 5px;
                border-radius: 4px;
                border: 1px solid #ccc;
            }

            .submit-btn {
                padding: 10px 20px;
                background-color: #4CAF50;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="user-info">

                    <span>Welcome <%= request.getAttribute("name")%></span>
                </div>
                <form method="get" action="logout">
                    <button class="logout-btn">Logout</button>
                </form>
            </div>

            <h2 class="form-title">Add Student</h2>

            <form action="add" method="POST">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="id">ID:</label>
                    <input type="text" id="id" name="id" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="tel" id="phone" name="phone" required>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" id="address" name="address" required>
                </div>
                <div class="form-group">
                    <label for="gender">Gender:</label>
                    <select id="gender" name="gender" required>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </div>
                <button type="submit" class="submit-btn">Add</button>

            </form>

        </div>
    </body>
</html>
