package com.mes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mes.model.Orders;
import com.mes.model.User;
import com.razorpay.Order;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByUser(User user);

	void save(Order order);

	Orders findByOrderNumber(String orderId);

	 long count();

	List<Orders> findByUserOrderByOrderDateDesc(User user);
}
