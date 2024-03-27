package com.fluxsparkapp.sampledataclass;

import java.lang.reflect.InvocationTargetException;

import com.fluxsparkapp.annotation.MapToClass;
import com.fluxsparkapp.util.Mapper;

@MapToClass(targetClass = EmployeeDto.class)
public class Employee {
	
	private long id;
	private String empName;
	private String jobName;
	private String emailId;
	public Employee( ) {}
	public Employee(long id, String empName, String jobName, String emailId) {
		super();
		this.id = id;
		this.empName = empName;
		this.jobName = jobName;
		this.emailId = emailId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
    public Employee copy(Employee employee) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        return Mapper.copy(employee);
    }
	
}
