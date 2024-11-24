package com.mes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mes.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category> findAll();

	Category findByName(String name);
	
	List<Category> findByNameIn(List<String> categoryNames);


}