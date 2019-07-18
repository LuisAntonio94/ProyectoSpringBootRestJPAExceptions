package com.everis.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.entities.StudentEntity;
import com.everis.exception.DataException;
import com.everis.exception.ResourceNotFoundException;
import com.everis.serviceInterfaz.IStudentService;


@RestController
@RequestMapping(path="/Student")
public class StudentController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IStudentService studentService;
	
	
	@PostMapping(value="/Save", consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<?> createStudent(@Valid @RequestBody StudentEntity student) {
		
		if(!student.getGender().equals("femenino") && !student.getGender().equals("masculino")) {
			throw new DataException("The gender option is only feminine or masculine!!!");
		}
		
		StudentEntity stud = studentService.saveStudent(student);
		
		if(stud == null) {
			logger.warn("Student not save!!!");
			throw new ResourceNotFoundException("Student not save!!!");
		}
		
		return new ResponseEntity<>(stud, HttpStatus.CREATED);
	}	

	
	@GetMapping(value="/FindById/{studentid}", produces = {"application/json"})
	public ResponseEntity<?> getStudentById(@Valid @PathVariable int studentid) {
		
		StudentEntity student = studentService.findById_student(studentid);
		
		if(student == null){
			logger.warn("student id not found!!!");
			throw new ResourceNotFoundException("student id not found!!!");
		}
		
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	
	@GetMapping(value="/FindAll", produces = {"application/json"})
	public ResponseEntity<?> getStudent(){
				
		List<StudentEntity> list = studentService.getStudents();
		
		if(list==null)
			throw new ResourceNotFoundException("Students not found!!!");
			
		return new ResponseEntity<List<StudentEntity>>(list, HttpStatus.OK);
		
	}

	@PutMapping(value="/Update/{studentid}", consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<?> updateStudent(@PathVariable int studentid, @RequestBody StudentEntity studentnew) {
		
		StudentEntity student = studentService.findById_student(studentid);
		
		if(student == null){
			logger.warn("student id not found!!!");
			throw new ResourceNotFoundException("student id not found!!!");
		}
		
		student = studentService.updateStudent(studentnew);
		
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@DeleteMapping(value="/Delete/{studentid}")
	public ResponseEntity<?> deleteStudent(@PathVariable int studentid) {
		
		if(studentService.findById_student(studentid) == null) {
			logger.warn("student id not found!!!");
			throw new ResourceNotFoundException("student id not found!!!");
		}
		studentService.deleteStudent(studentid);
		
		return new ResponseEntity<>("Student Successfully Deleted!!!",HttpStatus.OK);
	}

}
