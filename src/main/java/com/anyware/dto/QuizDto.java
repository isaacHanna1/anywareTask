package com.anyware.dto;

import java.util.List;

public class QuizDto {

	    private long quizId;
	    private String quizName;
	    private CourseDto courseDto;
	    private List<QuestionDto> questions;
		public long getQuizId() {
			return quizId;
		}
		public String getQuizName() {
			return quizName;
		}
		public List<QuestionDto> getQuestions() {
			return questions;
		}
		public void setQuizId(long quizId) {
			this.quizId = quizId;
		}
		public void setQuizName(String quizName) {
			this.quizName = quizName;
		}
		public void setQuestions(List<QuestionDto> questions) {
			this.questions = questions;
		}
		public CourseDto getCourseDto() {
			return courseDto;
		}
		public void setCourseDto(CourseDto courseDto) {
			this.courseDto = courseDto;
		}

	
}
