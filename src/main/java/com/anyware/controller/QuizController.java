package com.anyware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anyware.dto.QuizDto;
import com.anyware.entities.Quiz;
import com.anyware.service.QuizServices;

@RestController
@RequestMapping("/quizApi")
public class QuizController {

	@Autowired
	private QuizServices quizServices;
	
	@GetMapping("/all")
	public List<QuizDto> getAllQuizess(){
		return quizServices.getAllQuiz();
	}
	
	@GetMapping("quiz/{quizId}")
	public QuizDto getQuizById(@PathVariable long quizId) {
		return quizServices.getQuizById(quizId);
	}
	
	@DeleteMapping("del/{quizId}")
	public QuizDto deleteQuiz(@PathVariable long quizId) {
		return quizServices.deleteQuiz(quizId);
	}
	
	@PostMapping("/create")
	public Quiz create(@RequestBody QuizDto quizDto){
		return quizServices.createQuiz(quizDto);
	}

	@PutMapping("/update")
	public QuizDto update(@RequestBody QuizDto quizDto){
		quizServices.updateQuiz(quizDto);
		return quizDto;
	}
	
	
}
