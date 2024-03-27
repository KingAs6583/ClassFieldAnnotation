package com.fluxsparkapp.sampledataclass;

import com.fluxsparkapp.annotation.MapToClass;

@MapToClass(targetClass = Employee.class)
public class EmployeeDto {
	
	private long id;
	private String empName;
	private String jobName;
	private String emailId;
	public EmployeeDto() {}
	public EmployeeDto(long id, String empName, String jobName, String emailId) {
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


}
