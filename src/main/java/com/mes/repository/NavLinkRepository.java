package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mes.model.NavLink;

public interface NavLinkRepository extends JpaRepository<NavLink, Long> {
    // Add custom queries if needed
}