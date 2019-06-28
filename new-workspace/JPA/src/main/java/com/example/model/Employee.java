package com.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee {

//	@Id
//	@Column(name = "E_ID")
//	private int id;
	
	@EmbeddedId
	private EmpId id;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name="DEPT_EMP",
	  joinColumns= {@JoinColumn(name = "E_ID"),@JoinColumn(name = "D_NAME")},
	  inverseJoinColumns= {@JoinColumn(name="D_ID")})
	private Department department;
	
	
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public EmpId getId() {
		return id;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public void setId(EmpId id) {
		this.id = id;
	}

	@Column(name = "E_NAME")
	private String name;
	private double salary;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private LocalDate dob;
	private LocalDateTime joinDate;
	@Lob
	private String profile;
	@Lob
	private byte[] pic;

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id.getEmpId() + ", name=" + name + ", salary=" + salary + ", gender=" + gender + ", dob=" + dob
				+ ", joinDate=" + joinDate + ", profile=" + profile + ", pic=" + Arrays.toString(pic) + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

}