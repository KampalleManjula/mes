package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mes.model.Deal;

public interface DealRepository extends JpaRepository<Deal, Integer> {

}
