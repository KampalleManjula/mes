package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mes.model.Roaddress;
@Repository
public interface RoaddressRepository extends JpaRepository<Roaddress, Long> {

}
