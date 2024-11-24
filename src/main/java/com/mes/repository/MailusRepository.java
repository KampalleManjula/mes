package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mes.model.Mailus;

@Repository
public interface MailusRepository extends JpaRepository<Mailus, Long> {

}
