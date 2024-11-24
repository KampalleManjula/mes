package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mes.model.Downloadapps;
@Repository
public interface DownloadappsRepository extends JpaRepository<Downloadapps, Long>{

}
