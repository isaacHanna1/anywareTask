package com.anyware.dao;

import java.util.List;
import com.anyware.dto.CourseDto;
import com.anyware.entities.Course;

public interface CourseDao {
	
	
	public void saveCourse(Course course);
	public Course getCourseById(long id);
	public List<CourseDto> getAllCourses();
	public List<Course> getCoursesById(List<Long> coursesID);
	public void updateCourse(Course course);
	public void deleteCourse(long id);

}
