package com.mes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mes.model.DropChild;

public interface DropChildRepository extends JpaRepository<DropChild, Long> {
    List<DropChild> findByDropdownItemId(Long dropdownItemId);
   
}
