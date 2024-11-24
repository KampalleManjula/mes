package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mes.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
	

	boolean existsByEmail(String email);

	User findByEmail(String username);

		

	User findByName(String name);


	boolean existsByName(String name);

	long count();

}