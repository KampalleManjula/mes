package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mes.model.CardItem;



public interface CardItemRepository extends JpaRepository<CardItem, Integer> {
}
