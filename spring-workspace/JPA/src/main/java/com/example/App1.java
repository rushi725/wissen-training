package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.model.Department;
import com.example.model.EmpId;
import com.example.model.Employee;
import com.example.model.Gender;

public class App1 {

	public static void main(String[] args) {

		Employee employee = new Employee();
		EmpId empId = new EmpId();
		empId.setDeptName("IT");
		empId.setEmpId(11);
		employee.setId(empId);
		employee.setName("Nilesh");
		employee.setSalary(1200.00);
		employee.setGender(Gender.MALE);
		employee.setDob(LocalDate.now());
		employee.setJoinDate(LocalDateTime.now());
		
		Department department = new Department();
		department.setId(101);
		department.setName("IT");
		department.setDeptManager(employee);
		employee.setDepartment(department);


		// -------------------------------------------
		// using JPA
		// -------------------------------------------

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(employee);
		//em.persist(department);
		String jpql = "from Employee e";
		//Query query = em.createQuery(jpql);
		//List<Employee> employees = query.getResultList();
		//employees.forEach(System.out::println);
		

		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}