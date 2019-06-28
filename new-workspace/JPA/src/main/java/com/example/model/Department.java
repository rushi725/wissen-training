package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Department {
	@Id
	@Column(name = "D_ID")
	private int id;
	private String name;
	@OneToOne(mappedBy = "department", targetEntity = Employee.class)
	private Employee deptManager;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee getDeptManager() {
		return deptManager;
	}
	public void setDeptManager(Employee deptManager) {
		this.deptManager = deptManager;
	}
}
