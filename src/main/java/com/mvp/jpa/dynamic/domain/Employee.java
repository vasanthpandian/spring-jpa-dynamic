// tag::sample[]
package com.mvp.jpa.dynamic.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Date doj;
    private Date dob;

    protected Employee() {}

    public Employee(String firstName, String lastName, String doj) {
        this.firstName = firstName;
        this.lastName = lastName;
        Date date = null;
		try {
			date = new SimpleDateFormat("MM-dd-yyyy").parse(doj);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        this.doj = date;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[id=%d, firstName=%s, lastName=%s, doj=%s]",
                id, firstName, lastName,doj);
    }

// end::sample[]

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}

