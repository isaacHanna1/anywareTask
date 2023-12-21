package com.anyware.entities;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="questions")
public class Question {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private long questionId;
	    

	    @Column(name = "question_text")
	    private String questionText;
	    
	    @ElementCollection
	    @CollectionTable(name = "question_options", 
	    joinColumns = @JoinColumn(name = "question_id"))
	    @Column(name = "option")
	    private List<String> options;


	    @Column(name = "correct_answer")
	    private String correctAnswer;

	    @ManyToOne
	    @JoinColumn(name="quizId")
	    private Quiz quiz ;

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

		public Quiz getQuiz() {
			return quiz;
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

		public void setQuiz(Quiz quiz) {
			this.quiz = quiz;
		}
	    
	    
	    

}
