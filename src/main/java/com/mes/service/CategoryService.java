package com.mes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.model.Category;
import com.mes.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


  


    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    public Category getCategoryById(int categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

        return optionalCategory.orElse(null);
    }


	public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


	public List<Category> getCategoriesByName(List<String> categoryNames) {
        return categoryRepository.findByNameIn(categoryNames);
    }




	
}