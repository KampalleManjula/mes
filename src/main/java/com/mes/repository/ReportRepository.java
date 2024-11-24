package com.mes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mes.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
	List<Report> findByEmail(String email);
   
}