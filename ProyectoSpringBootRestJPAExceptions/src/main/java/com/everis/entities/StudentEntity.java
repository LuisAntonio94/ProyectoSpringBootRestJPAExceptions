package com.everis.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="STUDENTS")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "student_id", nullable = false)
	private int student_id;

	@NotNull(message = "The gender can not be empty")
	@Size(min = 1, max = 10, message = "The length of the gender must be between 1 and 10 characters.")
	@Column(name = "gender", nullable = false, length = 20)
	private String gender;
	
	@NotNull(message = "The first_name can not be empty")
	@Column(name = "first_name", nullable = false, length = 30)
	private String first_name;
	
	@NotNull(message = "The middle_name can not be empty")
	@Column(name = "middle_name", nullable = false, length = 30)
	private String middle_name;
	
	@NotNull(message = "The last_name can not be empty")
	@Column(name = "last_name", nullable = false, length = 30)
	private String last_name;
	
	@NotNull(message = "The date_Birth can not be empty")
	@Column(name = "date_Birth", nullable = false)
    @Temporal(TemporalType.DATE)
	private Date date_Birth;
	
	@NotNull(message = "The other_student_details can not be empty")
	@Column(name="other_student_details", nullable = false, length = 50)
	private String other_student_details;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="student_parents",
	joinColumns=@JoinColumn(name="student_id"),
	inverseJoinColumns=@JoinColumn(name="parent_id"))
	private List<ParentEntity> parents;
	
	 
	 
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getDate_Birth() {
		return date_Birth;
	}

	public void setDate_Birth(Date date_Birth) {
		this.date_Birth = date_Birth;
	}

	public String getOther_student_details() {
		return other_student_details;
	}

	public void setOther_student_details(String other_student_details) {
		this.other_student_details = other_student_details;
	}

	public List<ParentEntity> getParents() {
		return parents;
	}

	public void setParents(List<ParentEntity> parents) {
		this.parents = parents;
	}
}
