package com.mes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mes.model.GrandChild;

public interface GrandChildRepository extends JpaRepository<GrandChild, Long> {
    List<GrandChild> findByDropChildOfChildId(Long dropChildOfChildId);
   
}