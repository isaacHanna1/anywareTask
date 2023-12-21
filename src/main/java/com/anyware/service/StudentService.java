package com.anyware.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anyware.dao.CourseDao;
import com.anyware.dao.StudentDao;
import com.anyware.dto.StudentDto;
import com.anyware.entities.Course;
import com.anyware.entities.Student;

@Service
public class StudentService {

	
	@Autowired
	private StudentDao studentDao ;
	
	@Autowired
	private CourseDao courseDao; 
	
	@Transactional
	public void saveStudent(StudentDto studentDto) {
		
		Student student = new Student();
		student.setId(studentDto.getId());
		student.setF_name(studentDto.getF_name());
		student.setL_name(studentDto.getL_name());
		student.setEmail(studentDto.getEmail());
		student.setNationalId(studentDto.getNationalId());
		studentDao.saveStudent(student);
	}
	
	@Transactional
	public StudentDto getStudentById(long id) {
		Student student = studentDao.getStudent(id);
		return StudentDto.fromEntity(student);
	}
	
	@Transactional
	public StudentDto getStudentByName(String name) {
		
		Student student = studentDao.getStudent(name);
		return StudentDto.fromEntity(student);
	}
	

    @Transactional
    public void updateStudent(StudentDto studentDto) {
        Student student = StudentDto.toEntity(studentDto);
        studentDao.updateStudent(student);
    }
    
    @Transactional
    public void deleteStudentById(long id) {
        studentDao.deleteStudent(id);
    }

    @Transactional
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentDao.getAllStudent();
        List<StudentDto> studentDtos = new ArrayList<StudentDto>();
        for(int i = 0 ; i < students.size() ; i++) {
        	StudentDto dto = StudentDto.fromEntity(students.get(i));
        	studentDtos.add(dto);
        }
        return studentDtos;
    }
    
    @Transactional
    public void student_course_Register(long studentId , List<Long> coursesIds) {
        Student student = studentDao.getStudent(studentId);
        List<Course> courses = courseDao.getCoursesById(coursesIds);
        student.getEnrolledCourses().clear();
        studentDao.updateStudent(student);
        if(courses !=null) {
        student.getEnrolledCourses().addAll(courses);
        studentDao.updateStudent(student);
        }
    }

    @Transactional
    public List<Course> getCoursesThatStudentrChoosenBefore(long studentId){
    	List<Course> courses = studentDao.getCoursesThatStuedentChoosed(studentId);
    	return courses;
    }
    @Transactional
    public List<Long> getCoursesIdThatStudentChoosen(long studentId){
    	List<Course> courses = getCoursesThatStudentrChoosenBefore(studentId);
    	List<Long> coursesId = new ArrayList<>();
    	for(Course course : courses) {
    		coursesId.add(course.getCourseId());
    	}   	
    	return coursesId;
    }

}
