package com.anyware.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="quizzess")
public class Quiz {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private long quizId;
	    
	    
	    @Column(name = "name")
	    private String quizName;
	    
	  
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "course_id")
	    private Course course;
	    
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz" , cascade = CascadeType.ALL)
	    private List<Question> questions;

		public long getQuizId() {
			return quizId;
		}

		public String getQuizName() {
			return quizName;
		}

	

		public Course getCourse() {
			return course;
		}

		public List<Question> getQuestions() {
			return questions;
		}

		public void setQuizId(long quizId) {
			this.quizId = quizId;
		}

		public void setQuizName(String quizName) {
			this.quizName = quizName;
		}

	
		public void setCourse(Course course) {
			this.course = course;
		}

		public void setQuestions(List<Question> questions) {
			this.questions = questions;
		}


}
