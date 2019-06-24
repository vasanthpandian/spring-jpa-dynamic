package com.mvp.jpa.dynamic.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvp.jpa.dynamic.domain.Employee;
import com.mvp.jpa.dynamic.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// -------------------Retrieve All Users
	// ---------------------------------------------

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> listAllUsers(
			@RequestParam("date") @DateTimeFormat(pattern = "MM-dd-yyyy") Date doj, @RequestParam("limit") int limit,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName) {
		List<Employee> users = employeeService.findByCriteria(doj, limit, id, firstName, lastName);
		if (users.isEmpty()) {
			users = new ArrayList<Employee>();
		}
		return new ResponseEntity<List<Employee>>(users, HttpStatus.OK);
	}
}
