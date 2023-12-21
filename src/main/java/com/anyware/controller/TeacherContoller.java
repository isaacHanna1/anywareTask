package com.anyware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anyware.dto.TeacherDto;
import com.anyware.service.TeacherServices;

@Controller
@RequestMapping("/teachers")
public class TeacherContoller {

	@Autowired
	TeacherServices teaherServices;
	
	@GetMapping("/list")
	public String listOfTeachers(Model model) {
		model.addAttribute("teachers",teaherServices.getAllTeachers());
		return "teachers/list";
	}
	
	@GetMapping("/del/{id}")
	public String delteTeacher(@PathVariable long id ) {
		teaherServices.deleteTeacher(id);
		return "redirect:/teachers/list";
	}
	
	@PostMapping("/create")
	public String createTeacher(TeacherDto teacherDto) {
		teaherServices.createTeacher(teacherDto);
		return "redirect:/teachers/list";
	}
	
	@GetMapping("/add")
	public String addTeacherView() {
		return "teachers/create";
	}
	
	@GetMapping("/update/{id}")
	public String updateView(Model model,@PathVariable long id) {
		model.addAttribute("teacher", teaherServices.getTeacher(id));
		return "/teachers/update";
	}
	
	@PostMapping("/update")
	public String update(TeacherDto teacherDto){
		teaherServices.updateTeacher(teacherDto);
		return "redirect:/teachers/list";
	}
}
