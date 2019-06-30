package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Completed;
import com.example.demo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
	@Query("from Todo t where t.completed = :completed")
	List<Todo> findAllByCompleted(Completed completed);
	//add edit complete delete clearComplete completeAll sort filter 

}
