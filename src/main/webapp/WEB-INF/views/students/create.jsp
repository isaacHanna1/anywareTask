<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>
<body>

    <h2>Add Student</h2>

    <form action="/students/create" method="post">
        <label>First Name:</label>
        <input type="text" name="f_name" required><br>

        <label>Last Name:</label>
        <input type="text" name="l_name" required><br>

       
        <label>National ID:</label>
        <input type="text" name="nationalId" required><br>

        <label>Email:</label>
        <input type="email" name="email" required><br>

        <button type="submit">Add Student</button>
    </form>

</body>
</html>
