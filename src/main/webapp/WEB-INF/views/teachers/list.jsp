<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Teacher List</title>
</head>
<body>
    <h2>teacher List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>email</th>
            <th>Courses</th>
            <th>edit?</th>
            <th>delete?</th>
        </tr>
        <c:forEach var="teacher" items="${teachers}">
            <tr>
                <td>${teacher.teacherId}</td>
                <td>${teacher.firstName}</td>
                <td>${teacher.lastName}</td>
                <td>${teacher.email}</td>
                <td>course</td>
                <td><a href="/teachers/update/${teacher.teacherId}">edit</a></td>
                <td><a href="/teachers/del/${teacher.teacherId}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <button><a href="/teachers/add">Add Teacher</a></button>
</body>
</html>
