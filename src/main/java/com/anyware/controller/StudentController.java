package com.anyware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anyware.dto.StudentCourseRegister;
import com.anyware.dto.StudentDto;
import com.anyware.service.CourseService;
import com.anyware.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	

	@GetMapping("/list")
	 public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students/list";
	 }
	
	@GetMapping("/del/{id}")
	public String deleteStudent(@PathVariable long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students/list";
	}
	
	@GetMapping("/courseRegisterView/{studentId}")
	public String courseRegisteration(@PathVariable long studentId , Model model) {
		model.addAttribute("student", studentService.getStudentById(studentId));
		model.addAttribute("courses", courseService.getAllCourses());
		model.addAttribute("choosenCourses", studentService.getCoursesIdThatStudentChoosen(studentId));
		return "students/courseRegisteration";
	}
	
	@PostMapping("/regester_course")
	public String courser_student_register(StudentCourseRegister courseRegister,Model model) {
		studentService.student_course_Register(courseRegister.getStudentId(), courseRegister.getCourseIds());
		return "redirect:/students/list";
	}
	@GetMapping("/add")
	public String createView() {
		return "students/create";
	}
	
	@PostMapping("/create")
	public String createStudent(StudentDto studentDto){
		studentService.saveStudent(studentDto);
		return "redirect:/students/list?sucess";
	}
	
	@GetMapping("/updateView/{studentID}")
	public String updateView(Model model , @PathVariable long studentID) {
		
		StudentDto studentDto =	studentService.getStudentById(studentID);
		model.addAttribute("student", studentDto);
		return "students/update";
	}
	
	@PostMapping("/update")
	public String updateStudent(StudentDto dto) {
		studentService.updateStudent(dto);
		return "redirect:/students/list?sucess";
	}
}
