package com.anyware.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anyware.dto.QuizDto;
import com.anyware.entities.Quiz;

@Repository
public class QuizDaoImp implements QuizDao {

	@Autowired
	private SessionFactory mySessionFactory;
	
	
	
	@Override
	public List<Quiz> getAllQuiz() {

		String Hql = "FROM Quiz";
		Query< Quiz> query = getCurrentSession().createQuery(Hql, Quiz.class);
		List<Quiz> quizess = query.getResultList();
		return quizess;
	}

	@Override
	public Quiz getQuizById(long quizId) {
		return getCurrentSession().get(Quiz.class, quizId);
	}

	@Override
	public Quiz createQuiz(Quiz quiz) {
		getCurrentSession().save(quiz);
		return quiz;
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		getCurrentSession().update(quiz);
		return quiz;
	}

	@Override
	public Quiz deleteQuiz(long quizId) {
		Quiz quiz = getCurrentSession().get(Quiz.class, quizId);
		if(quiz !=null) {
			getCurrentSession().delete(quiz);
			return quiz;
		}
		return null;
	}


	private Session getCurrentSession() {
		return mySessionFactory.getCurrentSession();
	}
}
