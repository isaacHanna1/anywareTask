package com.anyware.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anyware.entities.Course;
import com.anyware.entities.Student;

import java.util.List;

import org.hibernate.Session;


@Repository
public class StudentDaoImp implements StudentDao {

	@Autowired
	private SessionFactory mySessionFactory;
	
	@Override
	public void saveStudent(Student student) {
		getCurrentSession().save(student);
	}

	@Override
	public Student getStudent(long id) {
        return getCurrentSession().get(Student.class, id);
	}
	@Override
	public Student getStudent(String fname) {

		String hql = "From Student WHERE f_name = :name";
		Query<Student> query = getCurrentSession()
				       .createNamedQuery(hql, Student.class);
		query.setParameter("name", fname);
		return query.uniqueResult();
		
	}


	@Override
	public void deleteStudent(long id) {

	Student student = getCurrentSession().get(Student.class, id);
	
		if(student !=null) {
		getCurrentSession().delete(student);
		}
	}

	@Override
	public void updateStudent(Student student) {
        getCurrentSession().update(student);
	}

	
	@Override
	public List<Student> getAllStudent() {
		
        String hql = "FROM Student";
        Query<Student> query = getCurrentSession().createQuery(hql,Student.class);
		return query.getResultList();
		
	}
	
	private Session getCurrentSession() {
		return mySessionFactory.getCurrentSession();
	}

	@Override
	public List<Course> getCoursesThatStuedentChoosed(long studentId) {

		Student student =   getCurrentSession().get(Student.class, studentId);
		return student.getEnrolledCourses();
	}


	
}
