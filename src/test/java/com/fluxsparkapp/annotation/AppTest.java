package com.fluxsparkapp.annotation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Test;

import com.fluxsparkapp.sampledataclass.Employee;
import com.fluxsparkapp.sampledataclass.EmployeeDto;
import com.fluxsparkapp.util.Mapper;

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
    }
    
    
    
    @Test
    public void matchEmployeeWithEmployeeDto() {
    	employee = dataClass.getEmployee();
    	try {
			employeeDto = Mapper.map(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	assertEquals(employee.getId(), employeeDto.getId());
    }
    
    @Test
    public void matchEmployeeDtoWithEmployee() {
    	employeeDto = dataClass.getEmployeeDto();
    	try {
    		employee = Mapper.map(employeeDto);
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
    
}
