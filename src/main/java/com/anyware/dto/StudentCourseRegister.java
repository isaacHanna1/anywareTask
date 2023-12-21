package com.anyware.dto;

import java.util.List;

public class StudentCourseRegister {

	

    private Long studentId;
    private List<Long> courseIds;
    
	public Long getStudentId() {
		return studentId;
	}
	public List<Long> getCourseIds() {
		return courseIds;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public void setCourseIds(List<Long> courseIds) {
		this.courseIds = courseIds;
	}
    
    
    
}
