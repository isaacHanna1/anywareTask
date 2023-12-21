<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Teacher</title>
</head>
<body>
    <h2>Update Teacher</h2>
    <form action="/teachers/update" method="post">
        <input type="hidden" name="teacherId" value="${teacher.teacherId}">
        <label>First Name: <input type="text" name="firstName" value="${teacher.firstName}" required></label><br>
        <label>Last Name: <input type="text" name="lastName" value="${teacher.lastName}" required></label><br>
        <label>Email: <input type="email" name="email" value="${teacher.email}" required></label><br>
        <button type="submit">Update</button>
    </form>
</body>
</html>
