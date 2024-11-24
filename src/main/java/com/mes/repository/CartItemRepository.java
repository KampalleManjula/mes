package com.mes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mes.model.CartItem;
import com.mes.model.Product;
import com.mes.model.User;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByUser(User user);
    
    CartItem findByUserAndProduct(User user, Product product);

   


	
}