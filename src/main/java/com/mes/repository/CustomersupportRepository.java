package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mes.model.Customersupport;
@Repository
public interface CustomersupportRepository extends JpaRepository<Customersupport, Long>{

}
