package com.anyware.dto;



public class CourseDto {


    private long courseId;
    private String courseName;
    private TeacherDto teacher;

    
    public CourseDto() {
		super();
	}

	public CourseDto(long courseId, String courseName, String teacherFirstName, String teacherLastName , long teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public CourseDto(long courseId , String courseName , long teacherId ) {
    	this.courseId = courseId;
        this.courseName = courseName;
    }
    
	public CourseDto(long courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}

	public long getCourseId() {
		return courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public TeacherDto getTeacher() {
		return teacher;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setTeacher(TeacherDto teacher) {
		this.teacher = teacher;
	}
    
}
