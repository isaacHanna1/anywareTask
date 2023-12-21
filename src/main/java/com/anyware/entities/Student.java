package com.anyware.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="fName")
	private String f_name;


	@Column(name="lName")
	private String l_name;
	
	
	@Column(name="nationalid")
	private long nationalId;
	
	@Column(name="email")
	private String email;
	
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="student_course",
			joinColumns = @JoinColumn(name="student_id"),
			inverseJoinColumns = @JoinColumn(name="course_id")
			)
	private List<Course> enrolledCourses ;

	
	
	
	
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
	
	
}
