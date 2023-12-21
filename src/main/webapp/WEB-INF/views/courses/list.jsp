<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Course List</title>
</head>
<body>
    <h2>Course List</h2>
    
    <table border="1">
        <thead>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Teacher</th>
                <th>Delete</th>
                <th>Edit</th>
                <!-- Add other columns as needed -->
            </tr>
        </thead>
        <tbody>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.courseId}</td>
                    <td>${course.courseName}</td>
                    <td></td>
                    <td><a href="/courses/del/${course.courseId}">delete</a></td>
                    <td><a href="/courses/update/${course.courseId}">edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <button><a href="/courses/add">Add course</a></button>
</body>
</html>
