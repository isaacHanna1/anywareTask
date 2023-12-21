package com.anyware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anyware.dao.CourseDao;
import com.anyware.dto.CourseDto;
import com.anyware.dto.TeacherDto;
import com.anyware.entities.Course;
import com.anyware.entities.Teacher;

@Service
public class CourseService {

	@Autowired
	CourseDao courseDao ;
	
	
	@Transactional
	public List<CourseDto> getAllCourses(){
		return courseDao.getAllCourses();
	}
	
	@Transactional
	public void create(CourseDto courseDto) {
		
		Course course = new Course();
		Teacher teacher = new Teacher();
		course.setCourseId(courseDto.getCourseId());
		course.setCourseName(courseDto.getCourseName());
		course.setTeacher(teacher);
		courseDao.saveCourse(course);
	}
	
	@Transactional
	public void deleteCourse(long id) {
		courseDao.deleteCourse(id);
	}
	
	@Transactional
	public CourseDto getCourseById(long id) {
		Course course = courseDao.getCourseById(id);
		CourseDto courseDto = new CourseDto ();
		TeacherDto teacherDto = new TeacherDto();
		
		courseDto.setCourseId(course.getCourseId());
		courseDto.setCourseName(course.getCourseName());
		teacherDto.setTeacherId(course.getTeacher().getTeacherId());
		courseDto.setTeacher(teacherDto);
		
		return courseDto;
	}
	
	@Transactional
	public void editCourse(CourseDto courseDto) {
		Course course = new Course();
		Teacher teacher = new Teacher();
		course.setCourseId(courseDto.getCourseId());
		course.setCourseName(courseDto.getCourseName());
		course.setTeacher(teacher);
		
		courseDao.updateCourse(course);
	}
}
