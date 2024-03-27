package com.fluxsparkapp.annotation;

import com.fluxsparkapp.sampledataclass.Employee;
import com.fluxsparkapp.sampledataclass.EmployeeDto;

public class DataClass {

	public EmployeeDto getEmployeeDto() {
    	EmployeeDto employeeDto = new EmployeeDto(0, "san", "cs", "check@gmail.com");
    	return employeeDto;
    }
    
    public Employee getEmployee() {
    	Employee employee = new Employee(1,"raj","science","raj@gamil.com");
    	return employee;
    }
}
