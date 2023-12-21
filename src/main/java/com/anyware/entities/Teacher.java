package com.anyware.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="teachers")
public class Teacher {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private long teacherId;

	    @Column(name = "first_name")
	    private String firstName;

	    @Column(name = "last_name")
	    private String lastName;

	    private String email;
	    
	    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	    private List<Course> taughtCourses;

		public long getTeacherId() {
			return teacherId;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getEmail() {
			return email;
		}

		public List<Course> getTaughtCourses() {
			return taughtCourses;
		}

		public void setTeacherId(long teacherId) {
			this.teacherId = teacherId;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setTaughtCourses(List<Course> taughtCourses) {
			this.taughtCourses = taughtCourses;
		}
	   
		
		

}
