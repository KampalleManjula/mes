package com.mes.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.mes.model.CartItem;
import com.mes.model.User;
import com.mes.model.UserDto;

public interface UserService {
	
	User save (UserDto userDto);
	
    boolean existsByEmail(String email);

	User findByEmail(String username);
	User getCurrentUser();

	User getUserById(Long userId);
	
	boolean login(String username, String password) ;
	List<CartItem> getCartItems(User user);

	Long getCurrentUserId();

	User getUserByEmail(String username);

	User getCurrentUser(Authentication authentication);

	User findById(Long id);

	//void save(User user);
	User save (User user);

	long GetCountUser();
}
