<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Teacher</title>
</head>
<body>
    <h2>Create Teacher</h2>
    <form action="/teachers/create" method="post">
        <label>First Name: <input type="text" name="firstName" required></label><br>
        <label>Last Name: <input type="text" name="lastName" required></label><br>
        <label>Email: <input type="email" name="email" required></label><br>
        <button type="submit">Create</button>
    </form>
</body>
</html>
