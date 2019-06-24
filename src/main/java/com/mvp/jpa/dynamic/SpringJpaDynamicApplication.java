
package com.mvp.jpa.dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mvp.jpa.dynamic.domain.Employee;
import com.mvp.jpa.dynamic.repository.EmployeeRepository;

@SpringBootApplication
public class SpringJpaDynamicApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringJpaDynamicApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDynamicApplication.class);
	}

	@Bean
	public CommandLineRunner demo(EmployeeRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Employee("Jack", "Bauer", "12-22-2011"));
			repository.save(new Employee("Chloe", "O'Brian", "12-21-2011"));
			repository.save(new Employee("Kim", "Bauer", "12-30-2011"));
			repository.save(new Employee("David", "Palmer", "12-19-2011"));
			repository.save(new Employee("Michelle", "Dessler", "12-18-2011"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Employee employee : repository.findAll()) {
				log.info(employee.toString());
			}
			log.info("");

			log.info("");
		};
	}

}
