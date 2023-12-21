package com.anyware.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anyware.dao.TeacherDao;
import com.anyware.dto.TeacherDto;
import com.anyware.entities.Teacher;

@Service
public class TeacherServices {

	@Autowired
	private TeacherDao teacherDao ;
	
	@Transactional
	public List<TeacherDto> getAllTeachers(){
		
		List<Teacher> allTeacher = teacherDao.getAllTeacher();
		List<TeacherDto> allTeacherDto = new ArrayList<>();
		for(int i = 0 ; i < allTeacher.size() ; i++) {
        	Teacher teacher = allTeacher.get(i);
			TeacherDto teacherDto = new TeacherDto();
			teacherDto.setTeacherId(teacher.getTeacherId());
			teacherDto.setFirstName(teacher.getFirstName());
			teacherDto.setLastName(teacher.getLastName());
			teacherDto.setEmail(teacher.getEmail());
        	allTeacherDto.add(teacherDto);
        }

		return allTeacherDto;	
	}
	
	@Transactional
	public void deleteTeacher(long id) {
		teacherDao.deleteTeacher(id);
	}
	
	@Transactional
	public void createTeacher(TeacherDto teacherDto) {

		Teacher teacher = new Teacher();
		teacher.setFirstName(teacherDto.getFirstName());
		teacher.setLastName(teacherDto.getLastName());
		teacher.setEmail(teacherDto.getEmail());
		teacherDao.save(teacher);
	}
	
	@Transactional
	public TeacherDto getTeacher(long id) {
		
		Teacher teacher =  teacherDao.getTeacherById(id);
		
		TeacherDto teacherDto = new TeacherDto();
		
		teacherDto.setTeacherId(teacher.getTeacherId());
		teacherDto.setFirstName(teacher.getFirstName());
		teacherDto.setLastName(teacher.getLastName());
		teacherDto.setEmail(teacher.getEmail());
		
		return teacherDto;
	} 
	
	@Transactional
	public void updateTeacher(TeacherDto teacherDto) {
		
		Teacher teacher = new Teacher();
		teacher.setTeacherId(teacherDto.getTeacherId());
		teacher.setFirstName(teacherDto.getFirstName());
		teacher.setLastName(teacherDto.getLastName());
		teacher.setEmail(teacherDto.getEmail());
		
		teacherDao.updateTeacher(teacher);
	}
	
	
	
}
