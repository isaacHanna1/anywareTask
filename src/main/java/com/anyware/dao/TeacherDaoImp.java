package com.anyware.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anyware.entities.Teacher;

@Repository
public class TeacherDaoImp implements TeacherDao{

	@Autowired
	private SessionFactory mySessionFactory;
	
	
	@Override
	public void save(Teacher teacher) {
		getCurrentSession().save(teacher);
	}

	@Override
	public List<Teacher> getAllTeacher() {

		String hql = "FROM Teacher";
		Query<Teacher> query = getCurrentSession().createQuery(hql, Teacher.class);
		return query.getResultList();
	}

	@Override
	public Teacher getTeacherById(long id) {
		
		Teacher teacher = getCurrentSession().get(Teacher.class, id);
		return teacher;
	}

	@Override
	public void deleteTeacher(long id) {
		Teacher teacher = getCurrentSession().get(Teacher.class, id);
		getCurrentSession().delete(teacher);
	}


	@Override
	public void updateTeacher(Teacher teacher) {
		getCurrentSession().update(teacher);
	}
	
	
	private Session getCurrentSession() {
		return mySessionFactory.getCurrentSession();
	}



}
