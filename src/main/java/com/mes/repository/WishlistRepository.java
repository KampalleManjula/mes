package com.mes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mes.model.Product;
import com.mes.model.User;
import com.mes.model.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

	Wishlist findByUserAndProduct(User user, Product product);

	List<Wishlist> findByUser(User user);

	boolean existsByProductAndUser(Product product, User user);

	int deleteByProductAndUser(Product product, User user);

	boolean existsByUserAndProduct(User user, Product product);

}
