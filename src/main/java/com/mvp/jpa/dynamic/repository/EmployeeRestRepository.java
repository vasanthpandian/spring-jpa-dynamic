package com.mvp.jpa.dynamic.repository;

import javax.validation.constraints.NotBlank;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mvp.jpa.dynamic.domain.Employee;

@RepositoryRestResource(collectionResourceRel = "emp", path = "emp")
public interface EmployeeRestRepository extends PagingAndSortingRepository<Employee, Long> {

	Employee findByFirstName(@Param("firstName") String firstName);
	
	Employee findByFirstNameAndLastName(@Param("firstName") @NotBlank String firstName, @Param("lastName") String lastName);
    
}