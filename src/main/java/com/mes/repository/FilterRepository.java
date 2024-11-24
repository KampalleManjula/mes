package com.mes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mes.model.Filter;


@Repository
public interface FilterRepository extends JpaRepository<Filter,Integer>
{


}