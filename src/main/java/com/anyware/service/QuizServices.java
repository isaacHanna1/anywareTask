package com.anyware.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anyware.dao.QuizDao;
import com.anyware.dto.CourseDto;
import com.anyware.dto.QuizDto;
import com.anyware.entities.Course;
import com.anyware.entities.Quiz;

@Service
public class QuizServices {

	@Autowired
	private QuizDao quizDao;
	
	@Transactional
	public List<QuizDto> getAllQuiz() {
		List<Quiz> quizess = quizDao.getAllQuiz();
		List<QuizDto> quizessDto = new ArrayList<>();

		for(Quiz quiz : quizess) {
			QuizDto quizDto = new QuizDto();
			quizDto.setQuizId(quiz.getQuizId());
			quizDto.setQuizName(quiz.getQuizName());
			Course course = quiz.getCourse();
			CourseDto courseDto = new CourseDto(course.getCourseId(),course.getCourseName());
			quizDto.setCourseDto(courseDto);
			quizessDto.add(quizDto);
		}
		return quizessDto;
	}
	
	@Transactional
	public QuizDto getQuizById(long quizId) {
		Quiz quiz = quizDao.getQuizById(quizId);
		QuizDto quizDto = new QuizDto();
		quizDto.setQuizId(quiz.getQuizId());
		quizDto.setQuizName(quiz.getQuizName());
		Course course = quiz.getCourse();
		CourseDto courseDto = new CourseDto(course.getCourseId(),course.getCourseName());
		quizDto.setCourseDto(courseDto);
		return quizDto;
	}
	
	@Transactional
	public QuizDto deleteQuiz(long quizId) {
		Quiz quiz = quizDao.deleteQuiz(quizId);
		QuizDto quizDto = new QuizDto();
		quizDto.setQuizId(quiz.getQuizId());
		quizDto.setQuizName(quiz.getQuizName());
		Course course = quiz.getCourse();
		CourseDto courseDto = new CourseDto(course.getCourseId(),course.getCourseName());
		quizDto.setCourseDto(courseDto);
		return quizDto;
	}
	
	@Transactional
	public Quiz createQuiz( QuizDto quizDto ) {
		
		
		Quiz quiz = new Quiz();
		quiz.setQuizId(quizDto.getQuizId());
		quiz.setQuizName(quizDto.getQuizName());
		CourseDto courseDto = quizDto.getCourseDto();
		Course course = new Course();
		course.setCourseId(courseDto.getCourseId());
		course.setCourseName(courseDto.getCourseName());
		quiz.setCourse(course);
		
		quizDao.createQuiz(quiz);
		return quiz;
	}
	
	@Transactional
	public Quiz updateQuiz(QuizDto quizDto) {
		
		
		Quiz quiz = new Quiz();
		quiz.setQuizId(quizDto.getQuizId());
		quiz.setQuizName(quizDto.getQuizName());
		CourseDto courseDto = quizDto.getCourseDto();
		Course course = new Course();
		course.setCourseId(courseDto.getCourseId());
		course.setCourseName(courseDto.getCourseName());
		quiz.setCourse(course);
		
		quizDao.updateQuiz(quiz);
		return quiz;
	}
	
}
