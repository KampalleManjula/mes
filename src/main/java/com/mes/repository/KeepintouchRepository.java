package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mes.model.Keepintouch;
@Repository
public interface KeepintouchRepository extends JpaRepository<Keepintouch, Long>{

}
