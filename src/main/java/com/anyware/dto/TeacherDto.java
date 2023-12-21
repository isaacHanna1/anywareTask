package com.anyware.dto;

import java.util.List;

public class TeacherDto {


    private long teacherId;
    private String firstName;
    private String lastName;
    private String email;
    private List<CourseDto> taughtCourses;
    
    
    
    
    
	public long getTeacherId() {
		return teacherId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<CourseDto> getTaughtCourses() {
		return taughtCourses;
	}
	public void setTaughtCourses(List<CourseDto> taughtCourses) {
		this.taughtCourses = taughtCourses;
	}
	

	
}
