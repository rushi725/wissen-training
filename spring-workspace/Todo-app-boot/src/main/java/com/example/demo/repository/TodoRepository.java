package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
	//add edit complete delete clearComplete completeAll sort filter 

}
