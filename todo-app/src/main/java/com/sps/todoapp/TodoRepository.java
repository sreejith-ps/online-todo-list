package com.sps.todoapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sps.todoapp.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}
