package com.anyware.dao;

import java.util.List;

import com.anyware.entities.Teacher;

public interface TeacherDao {

	
	 void save(Teacher teacher);
	
	 List<Teacher> getAllTeacher();
	
	 Teacher getTeacherById(long id);
	
	 void deleteTeacher(long id);
	 
	 void updateTeacher(Teacher teacher);
}
