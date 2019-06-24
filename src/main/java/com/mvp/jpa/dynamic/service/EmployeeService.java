package com.mvp.jpa.dynamic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mvp.jpa.dynamic.domain.Employee;
import com.mvp.jpa.dynamic.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository er;

	@SuppressWarnings("serial")
	public List<Employee> findByCriteria(Date doj, int limit, Long id, String firstName, String lastName) {
		Pageable pageRequest = PageRequest.of(0, limit, Sort.by("doj").descending());
		return er.findAll(new Specification<Employee>() {
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThan(root.get("doj"), doj)));
				if (id != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("id"), id)));
				}
				if (firstName != null && !firstName.isEmpty()) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("firstName"), firstName)));
				}
				if (lastName != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("lastName"), lastName)));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, pageRequest).getContent();
	}
}
