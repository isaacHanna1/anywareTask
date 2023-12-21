package com.anyware.dto;

import java.util.List;

public class QuestionDto {

	
	private long questionId;
    private String questionText;
    private List<String> options;
    private String correctAnswer;
    private long quizId;
    
    
	public long getQuestionId() {
		return questionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public List<String> getOptions() {
		return options;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public long getQuizId() {
		return quizId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}
    
    
    

}
