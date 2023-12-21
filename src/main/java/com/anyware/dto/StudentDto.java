package com.anyware.dto;

import java.util.List;
import com.anyware.entities.Course;
import com.anyware.entities.Student;

public class StudentDto {

	
	private long id ;
	private String f_name;
	private String l_name;
	private long nationalId;
	private String email;
	private List<Course> enrolledCourses ;
	
	

	public StudentDto() {
		super();
	}
	public long getId() {
		return id;
	}
	public String getF_name() {
		return f_name;
	}
	public String getL_name() {
		return l_name;
	}
	
	public long getNationalId() {
		return nationalId;
	}
	public String getEmail() {
		return email;
	}
	public List<Course> getEnrolledCourses() {
		return enrolledCourses;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public void setNationalId(long nationalId) {
		this.nationalId = nationalId;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEnrolledCourses(List<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	
	
	  public static Student toEntity(StudentDto studentDTO) {
	        Student student = new Student();
	        student.setId(studentDTO.getId());
	        student.setF_name(studentDTO.getF_name());
	        student.setL_name(studentDTO.getL_name());
	        student.setNationalId(studentDTO.getNationalId());
	        student.setEmail(studentDTO.getEmail());
	        return student;
	    }
	  
	    public static StudentDto fromEntity(Student student) {
	        StudentDto studentDto = new StudentDto();
	        studentDto.setId(student.getId());
	        studentDto.setF_name(student.getF_name());
	        studentDto.setL_name(student.getL_name());
	        studentDto.setNationalId(student.getNationalId());
	        studentDto.setEmail(student.getEmail());
	        return studentDto;
	    }
	
	
}
