package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mes.model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}