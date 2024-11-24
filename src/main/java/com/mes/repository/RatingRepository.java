package com.mes.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mes.model.Product;
import com.mes.model.Rating;
import com.mes.model.User;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    
	Rating findByUserAndProduct(User user, Product product);
	
	List<Rating> findAllByProduct(Product product, Sort sort);
	
}
