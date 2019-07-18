package com.everis.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;


@Entity
@Table(name="FAMILIES")
public class FamilyEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "family_id", nullable = false)
	private int family_id;
	
	@Column(name = "family_name", nullable = false, length = 30)
	@Max(30)
	private String family_name;
	
	/*
	@OneToOne
	@JoinColumn(name = "head_of_family_parent_id", referencedColumnName = "parent_id")
	private ParentEntity parent;
	
	@OneToOne
	@JoinColumn(name="head_of_family_parent_id")
	private ParentEntity parent;
	
	@OneToMany(mappedBy = "family", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ParentEntity> parents;
	
	*/

	public int getFamily_id() {
		return family_id;
	}


	public void setFamily_id(int family_id) {
		this.family_id = family_id;
	}


	public String getFamily_name() {
		return family_name;
	}


	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}
}
