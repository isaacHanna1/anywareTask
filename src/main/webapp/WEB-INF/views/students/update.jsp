<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>

    <h2>Edit Student</h2>

    <form action="/students/update" method="post">
        <input type="hidden" name="id" value="${student.id}">
        <label>First Name:</label>
        <input type="text" name="f_name" value="${student.f_name}" required><br>

        <label>Last Name:</label>
        <input type="text" name="l_name" value="${student.l_name}" required><br>

        <label>National ID:</label>
        <input type="text" name="nationalId" value="${student.nationalId}" required><br>

        <label>Email:</label>
        <input type="email" name="email" value="${student.email}" required><br>

        <button type="submit">Update Student</button>
    </form>

</body>
</html>
