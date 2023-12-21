<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Course</title>
</head>
<body>

    <h2>Edit Course</h2>

    <form action="/courses/update" method="post">
        <input type="hidden" name="courseId" value="${course.courseId}">
        
        <label>Course Name: <input type="text" name="courseName" value="${course.courseName}" required></label><br>
        
        <label>Teacher:
            <select name="teacherId" required>
                <c:forEach var="teacher" items="${teachers}">
                    <option value="${teacher.teacherId}" ${teacher.teacherId == course.teacher.teacherId ? 'selected' : ''}>${teacher.firstName} ${teacher.lastName}</option>
                </c:forEach>
            </select>
        </label><br>
        
        <!-- Add other fields as needed -->

        <button type="submit">Update</button>
    </form>

</body>
</html>
