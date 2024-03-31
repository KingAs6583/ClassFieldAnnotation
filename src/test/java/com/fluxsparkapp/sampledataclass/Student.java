package com.fluxsparkapp.sampledataclass;

import com.fluxsparkapp.annotation.MapToClasses;

@MapToClasses(targetClasses = {EmployeeDto.class,Employee.class})
public class Student {
	private long id;
	private String empName;
	private String jobName1;
	private String emailId;
	public Student( ) {}
	public Student(long id, String empName, String jobName, String emailId) {
		super();
		this.id = id;
		this.empName = empName;
		this.jobName1 = jobName;
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
		return jobName1;
	}
	public void setJobName(String jobName) {
		this.jobName1 = jobName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
