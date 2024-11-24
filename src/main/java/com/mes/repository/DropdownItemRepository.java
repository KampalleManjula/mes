package com.mes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mes.model.DropdownItem;

public interface DropdownItemRepository extends JpaRepository<DropdownItem, Long> {
	List<DropdownItem> findByNavLinkId(Long navLinkId);   // Add custom queries if needed
}