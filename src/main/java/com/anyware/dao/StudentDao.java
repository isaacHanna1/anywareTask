package com.anyware.dao;

import java.util.List;

import com.anyware.entities.Course;
import com.anyware.entities.Student;

public interface StudentDao {
	
	void saveStudent(Student student);
	List<Student> getAllStudent();
    Student getStudent(long id);
    Student getStudent(String name);
    
    void deleteStudent(long id);
    
    void updateStudent(Student student);
	
	public List<Course> getCoursesThatStuedentChoosed(long studentId);

}
