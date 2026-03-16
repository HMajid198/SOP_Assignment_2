package com.part2.coursework.csc2063.mic2.students;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsRestController {
	
	private final Students students = new Students();
	
	@GetMapping("/add/{id}")
	public Student addStudent(@PathVariable String id) {
		Student existing = students.findStudentById(id);
		if (existing != null)
		{
			return existing;
		}
		
		Student student = new Student(id);
		students.addStudent(student);
		return student;
	}
	
	@GetMapping("/findbyid/{id}")
	public Student findByStudentId(@PathVariable String id) {
		return students.findStudentById(id);
	}
	
	@PostMapping("/{id}/enrol/{moduleCode}")
	public Student enrolStudent(@PathVariable String id, @PathVariable String moduleCode) {
		Student student = students.findStudentById(id);
		if (student == null) return null;
		
		student.enrolModuleCode(ModuleCode.valueOf(moduleCode));
		return student;
	}
	
	@DeleteMapping("/{id}/enrol/{moduleCode}")
	public Student unenrolStudent(@PathVariable String id, @PathVariable String moduleCode) {
		Student student = students.findStudentById(id);
		if (student == null) return null;
		
		student.unenrolModuleCode(ModuleCode.valueOf(moduleCode));
		return student;
	}
	
	@PostMapping("/{id}/grade/{moduleCode}/{value}")
	public Student registerGrade(@PathVariable String id, @PathVariable String moduleCode, @PathVariable int value) {
		Student student = students.findStudentById(id);
		if (student == null) return null;
		
		student.registerGrade(ModuleCode.valueOf(moduleCode), value);
		return student;
	}
	
	@DeleteMapping("/{id}/grade/{moduleCode}")
	public Student unregisterGrade(@PathVariable String id, @PathVariable String moduleCode)
	{
		Student student = students.findStudentById(id);
		if (student == null) return null;
		
		student.unregisterGrade(ModuleCode.valueOf(moduleCode));
		return student;
	}
	
}

