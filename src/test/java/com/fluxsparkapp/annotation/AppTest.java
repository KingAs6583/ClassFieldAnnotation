package com.fluxsparkapp.annotation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fluxsparkapp.sampledataclass.Employee;
import com.fluxsparkapp.sampledataclass.EmployeeDto;
import com.fluxsparkapp.util.ClassMapper;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	Employee employee = null;
	EmployeeDto employeeDto  = null;
	DataClass dataClass = new DataClass();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
		System.out.println("Test Begin");
    }
    
    
    
    @Test
    public void matchEmployeeWithEmployeeDto() {
    	employee = dataClass.getEmployee();
    	try {
			employeeDto = ClassMapper.mapFrom(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	assertEquals(employee.getId(), employeeDto.getId());
    }
    
    @Test
    public void matchEmployeeDtoWithEmployee() {
    	employeeDto = dataClass.getEmployeeDto();
    	try {
    		employee = ClassMapper.mapFrom(employeeDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	assertEquals(employee.getId(), employeeDto.getId());
    }
    
    @Test
    public void matchSelfCopy() {
    	employee = dataClass.getEmployee();
    	try {
    	Employee employee2 = employee.copy(employee);
    	assertEquals(employee.getId(), employee2.getId());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
	
	@Test
	public void testCopyFields(){
		employee = dataClass.getEmployee();
		try {
			employeeDto = ClassMapper.copyFields(employee, EmployeeDto.class);
			assertEquals(employee.getId(), employeeDto.getId());
		} catch (Exception e) {
    		e.printStackTrace();
		}
	}

	@Test
	public void testClassesFrom(){
		employeeDto = dataClass.getEmployeeDto();
		try {
			employee = ClassMapper.mapClassesFrom(employeeDto, Employee.class);
			assertEquals(employee.getId(), employeeDto.getId());
		} catch (Exception e) {
    		e.printStackTrace();
		}
	}
}
