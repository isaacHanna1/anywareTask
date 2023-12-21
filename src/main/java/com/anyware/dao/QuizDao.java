package com.anyware.dao;

import java.util.List;

import com.anyware.entities.Quiz;

public interface QuizDao {
	
	List<Quiz> getAllQuiz();
	
	Quiz getQuizById(long quizId);
	
	Quiz createQuiz(Quiz quiz);
	
	Quiz updateQuiz(Quiz quiz);
	
	Quiz deleteQuiz(long quizId);

}
