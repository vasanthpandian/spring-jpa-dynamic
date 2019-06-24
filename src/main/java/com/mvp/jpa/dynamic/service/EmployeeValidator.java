package com.mvp.jpa.dynamic.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvp.jpa.dynamic.domain.Employee;

@Component("beforeCreateEmployeeValidator")
public class EmployeeValidator implements Validator {
 
    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.equals(clazz);
    }
 
    @Override
    public void validate(Object obj, Errors errors) {
    	Employee employee = (Employee) obj;
        if (checkInputString(employee.getFirstName())) {
            errors.rejectValue("firstName", "firstName.empty");
        }
    
        if (checkInputString(employee.getLastName())) {
            errors.rejectValue("lastName", "lastName.empty");
        }
    }
 
    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}