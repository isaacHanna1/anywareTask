package com.anyware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anyware.dto.CourseDto;
import com.anyware.service.CourseService;
import com.anyware.service.TeacherServices;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	CourseService courseService ;
	
	@Autowired
	TeacherServices teacherServices ;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("courses", courseService.getAllCourses());
		return "courses/list";
	}
	
	@GetMapping("/add")
	public String createView(Model model) {
		model.addAttribute("teachers", teacherServices.getAllTeachers());
		return "courses/create";
	}
	
	
	@PostMapping("/create")
	public String create(CourseDto courseDto) {
		courseService.create(courseDto);
		return "redirect:/courses/list";
	}
	
	@GetMapping("/del/{id}")
	public String deleteCourse(@PathVariable long id) {
		courseService.deleteCourse(id);
		return "redirect:/courses/list";
	}
	
	@GetMapping("/update/{id}")
	public String updateView(@PathVariable long id , CourseDto courseDto , Model model ) {
		model.addAttribute("teachers", teacherServices.getAllTeachers());
		model.addAttribute("course", courseService.getCourseById(id));
		return "courses/update";
	}
	
	@PostMapping("/update")
	public String update(CourseDto courseDto) {
		courseService.editCourse(courseDto);
		return "redirect:/courses/list";
	}

}
