package com.anyware.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Seha
 *
 */
@Entity
@Table(name="courses")
public class Course {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private long courseId;

    @Column(name = "course_name")
    private String courseName;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="teacher_id")
    private Teacher teacher;
    
    @ManyToMany(mappedBy = "enrolledCourses" , cascade = CascadeType.ALL)
    private List<Student> enrolledStudents;

    @OneToMany(mappedBy = "course")
    private List<Quiz> quiz ;

	public long getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	
	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public List<Quiz> getQuiz() {
		return quiz;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public void setQuiz(List<Quiz> quiz) {
		this.quiz = quiz;
	}




}
