package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mes.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

}
