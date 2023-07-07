package org.sid.app.controllers;

import java.util.List;

import org.sid.app.dto.StudentDto;
import org.sid.app.services.StudentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@PostMapping("/addStudent")
	public StudentDto add(@RequestBody StudentDto studentDto) {
		return studentService.add(studentDto);
	}

	@DeleteMapping("/deletesStudent/{studentId}")
	public void deleteById(@PathVariable Long studentId) {
		studentService.deleteById(studentId);
	}

	@GetMapping("/getStudent/{studentId}")
	public StudentDto findById(@PathVariable Long studentId) {
		return studentService.findById(studentId);
	}

	@GetMapping("/getAllStudents")
	public List<StudentDto> findAll() {
		return studentService.findAll();
	}
}
