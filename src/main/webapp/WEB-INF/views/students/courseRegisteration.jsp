<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Registration</title>
</head>
<body>

    <h2>Course Registration for ${student.f_name}</h2>

    <form action="/students/regester_course" method="post">
        <input type="hidden" name="studentId" value="${student.id}">

        <label>Student Name: ${student.f_name}</label><br>

        <label>Select Courses:</label><br>
        <c:forEach var="course" items="${courses}">
        
         <c:set var="checked" value="${choosenCourses.contains(course.courseId)}" />
         <input ${course.courseId.toString()} ${checked ? 'checked' : 'false'} type="checkbox" name="courseIds" value="${course.courseId}"> ${course.courseName}<br>
	    </c:forEach>
        <button type="submit">Register Courses</button>
    </form>

</body>
</html>
