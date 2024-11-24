package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mes.model.Address;
import com.mes.model.User;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	Address findDefaultAddressByUser(User user);

}
