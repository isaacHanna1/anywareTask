<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Course</title>
</head>
<body>

    <h2>Create New Course</h2>

    <form action="/courses/create" method="post">
        <label>Course Name: <input type="text" name="courseName" required></label><br>

        <label>Teacher:
            <select name="teacherId" required>
                <c:forEach var="teacher" items="${teachers}">
                    <option value="${teacher.teacherId}">${teacher.firstName} ${teacher.lastName}</option>
                </c:forEach>
            </select>
        </label><br>

        <button type="submit">Save</button>
    </form>

</body>
</html>
