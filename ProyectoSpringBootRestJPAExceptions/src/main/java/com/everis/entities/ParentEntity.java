package com.everis.entities;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="PARENTS")
public class ParentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "parent_id", nullable = false)
	private int parent_id;

	@Column(name = "gender", nullable = false, length = 20)
	private String gender;
	
	@Column(name = "first_name", nullable = false, length = 30)
	private String first_name;
	
	@Column(name = "middle_name", nullable = false, length = 30)
	private String middle_name;
	
	@Column(name = "last_name", nullable = false, length = 30)
	private String last_name;
	
	@Column(name="other_parent_details", nullable = false, length = 50)
	private String other_parent_details;
	
	/*
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "family_id", referencedColumnName = "family_id", nullable = false)
	private FamilyEntity family;
	
	*/
	
	@ManyToMany(mappedBy="parents", fetch = FetchType.LAZY)
	private List<StudentEntity> students;
	
	
	

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
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

	public String getOther_parent_details() {
		return other_parent_details;
	}

	public void setOther_parent_details(String other_parent_details) {
		this.other_parent_details = other_parent_details;
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}
	
}

