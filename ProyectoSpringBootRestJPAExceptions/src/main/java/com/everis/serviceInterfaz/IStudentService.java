package com.everis.serviceInterfaz;

import java.util.List;

import com.everis.entities.StudentEntity;

public interface IStudentService {

	public StudentEntity saveStudent(StudentEntity student);
	
	public List<StudentEntity> getStudents();
	
	public StudentEntity findById_student(int studentid);
	
	public StudentEntity updateStudent(StudentEntity student);
	
	public void deleteStudent(int studentid);
	
	
}
