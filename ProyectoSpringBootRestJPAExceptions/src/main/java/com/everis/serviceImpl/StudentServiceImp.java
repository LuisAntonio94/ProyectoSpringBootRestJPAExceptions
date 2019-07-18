package com.everis.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.entities.StudentEntity;
import com.everis.repository.StudentRepository;
import com.everis.serviceInterfaz.IStudentService;

@Service
public class StudentServiceImp implements IStudentService{

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public StudentEntity saveStudent(StudentEntity student) {

		StudentEntity stud = null;
		try {
			stud = studentRepository.save(student);
			logger.info("Student inserted!!!");
			return stud;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return stud;
		}
	}
	
	
	@Override
	public List<StudentEntity> getStudents() {

		return studentRepository.findAll();
	}
	
	
	@Override
	public StudentEntity findById_student(int studentid) {
		
		return studentRepository.findById(studentid).get();
	}
	
	
	@Override
	public StudentEntity updateStudent(StudentEntity student) {
		/* Lambda
		 studentRepository.findById(student.getStudent_id()).ifPresent((x) -> {
			studentRepository.save(student);
		});
		*/
		StudentEntity std=null;
		
		try {
			//if(studentRepository.existsById(student.getStudent_id())) 
				std = studentRepository.saveAndFlush(student);

			logger.info("Student updated!!!");
			return std;
		}catch(Exception e) {
			logger.error(e.getMessage());
			return std;
		}
	}
	

	@Override
	public void deleteStudent(int studentid) {
		
		try {
			studentRepository.deleteById(studentid);
			logger.info("Student deleted!!!");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

}
