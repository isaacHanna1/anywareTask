<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h2>Student List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>National ID</th>
            <th>Email</th>
            <th>Courses</th>
            <th>edit?</th>
            <th>delete?</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.f_name}</td>
                <td>${student.l_name}</td>
                <td>${student.nationalId}</td>
                <td>${student.email}</td>
                <td><a href="/students/courseRegisterView/${student.id}">register Courses</a></td>
                <td><a href="/students/updateView/${student.id}">edit</a></td>
                <td><a href="/students/del/${student.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    
    <button><a href="/students/add">Add new Student</a></button>
</body>
</html>
