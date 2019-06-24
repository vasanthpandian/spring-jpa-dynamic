package com.mvp.jpa.dynamic.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mvp.jpa.dynamic.domain.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Date>, JpaSpecificationExecutor<Employee> {

    
}
