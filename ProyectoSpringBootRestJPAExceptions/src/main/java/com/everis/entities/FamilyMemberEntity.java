package com.everis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FAMILY_MEMBERS")
public class FamilyMemberEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="family_member_id")
	private int family_member_id;
	
	@Column(name = "parents_or_student_member", nullable = false, length = 30)
	private String parents_or_student_member;
	/*
	@ManyToOne
	@JoinColumn(name = "family_id", referencedColumnName = "family_id")
	private FamilyEntity family;
	
	@ManyToOne
	@JoinColumn(name = "parent_id", referencedColumnName = "parent_id")
	private ParentEntity parent;
	
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	private StudentEntity student;

	
	public int getFamily_member_id() {
		return family_member_id;
	}

	public void setFamily_member_id(int family_member_id) {
		this.family_member_id = family_member_id;
	}

	public String getParents_or_student_member() {
		return parents_or_student_member;
	}

	public void setParents_or_student_member(String parents_or_student_member) {
		this.parents_or_student_member = parents_or_student_member;
	}

	public FamilyEntity getFamily() {
		return family;
	}

	public void setFamily(FamilyEntity family) {
		this.family = family;
	}

	public ParentEntity getParent() {
		return parent;
	}

	public void setParent(ParentEntity parent) {
		this.parent = parent;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}
	*/
	public int getFamily_member_id() {
		return family_member_id;
	}

	public void setFamily_member_id(int family_member_id) {
		this.family_member_id = family_member_id;
	}

	public String getParents_or_student_member() {
		return parents_or_student_member;
	}

	public void setParents_or_student_member(String parents_or_student_member) {
		this.parents_or_student_member = parents_or_student_member;
	}
}
