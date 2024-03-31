package com.fluxsparkapp.annotation;

import com.fluxsparkapp.sampledataclass.Employee;
import com.fluxsparkapp.sampledataclass.EmployeeDto;
import com.fluxsparkapp.sampledataclass.Student;

public class DataClass {

	public EmployeeDto getEmployeeDto() {
    	EmployeeDto employeeDto = new EmployeeDto(0, "san", "cs", "check@gmail.com");
    	return employeeDto;
    }
    
    public Employee getEmployee() {
    	Employee employee = new Employee(1,"raj","science","raj@gamil.com");
    	return employee;
    }
    
    public Student getStudent() {
    	return new Student(2,"raja","science","raj@gamil.com");
    }
}
