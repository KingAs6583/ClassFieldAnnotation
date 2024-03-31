# Class Field Annotations
This is a repo which has a 2 annoation to assign the values of one class having different name with same fields to another class which also have different name  having  same fields.

## How to Import this annotations to maven project

```xml
<project>
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
</project>
```
In dependency

```xml
<dependency>
    <groupId>com.github.KingAs6583</groupId>
    <artifactId>ClassFieldAnnotation</artifactId>
    <version>v1.1.0</version>
</dependency>
```
## How to use
Add the annotation on the class you want to map from and return to object

```java
import com.fluxsparkapp.annotation.MapToClass;
import com.fluxsparkapp.annotation.MapToClasses;
import com.fluxsparkapp.util.ClassMapper;

import com.fluxsparkapp.annotation.MapToClass;
import com.fluxsparkapp.annotation.MapToClasses;
import com.fluxsparkapp.util.ClassMapper;

@MapToClass(targetClass = EmployeeDto.class)
@MapToClasses(targetClasses = {EmployeeDto.class,Employee.class})
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
        return ClassMapper.copyFrom(employee);
    }
	
}

@MapToClass(targetClass = Employee.class)
@MapToClasses(targetClasses = {EmployeeDto.class,Employee.class})
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

```

### Implementation

```java
public class Test{
    public static void main(String args[]){
        Employee emp = new Employee(1,"john","dev","johndev@gmail.com");
        try{
            EmployeeDto empDto = ClassMapper.mapFrom(emp);
            System.out.println(empDto.getEmailId());
        }catch(Exception e){
			e.printStackTrace();
        }
    }
}
```