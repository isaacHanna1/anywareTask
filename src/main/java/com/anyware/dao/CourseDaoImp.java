package com.anyware.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anyware.dto.CourseDto;
import com.anyware.entities.Course;


@Repository
public class CourseDaoImp implements CourseDao {


	@Autowired
	private SessionFactory mySessionFactory;
	
	
	
	@Override
	public void saveCourse(Course course) {
		getCurrentSession().save(course);
	}

	@Override
	public Course getCourseById(long id) {
		Course course  = getCurrentSession().get(Course.class, id);
		System.out.println(course.getTeacher().getFirstName());
        return course;
	}

	@Override
	public List<CourseDto> getAllCourses() {
		
		String hql = "SELECT new com.anyware.dto.CourseDto(c.courseId, c.courseName, t.firstName, t.lastName ,t.teacherId) FROM com.anyware.entities.Course c JOIN c.teacher t";
		Query<CourseDto> query = getCurrentSession().createQuery(hql, CourseDto.class);
		return query.getResultList();
	}

	@Override
	public void updateCourse(Course course) {
		getCurrentSession().update(course);

	}

	@Override
	public void deleteCourse(long id) {

		Course course = getCurrentSession().get(Course.class, id);
		getCurrentSession().delete(course);

	}

	
	@Override
	public List<Course> getCoursesById(List<Long> coursesID) {

		if(coursesID !=null) {
		List<Course> courses = new ArrayList<>();
		for(Long courseId : coursesID) {
			Course course = getCurrentSession().get(Course.class, courseId);
			if (course != null) {
			courses.add(course);		
			}
		}
		return courses;
		}
		return null;
	}

	private Session getCurrentSession() {
		return mySessionFactory.getCurrentSession();
	}


	
}
