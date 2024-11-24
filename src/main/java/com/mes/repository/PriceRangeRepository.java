package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mes.model.PriceRange;

public interface PriceRangeRepository extends JpaRepository<PriceRange, Long> {
}