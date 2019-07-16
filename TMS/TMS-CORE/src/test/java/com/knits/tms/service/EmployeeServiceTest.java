package com.knits.tms.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.knits.tms.beans.EmployeeDto;
import com.knits.tms.dao.EmployeeDao;
import com.knits.tms.dao.RoleDao;
import com.knits.tms.model.Employee;
import com.knits.tms.model.Role;
import com.knits.tms.test.utils.AssertionUtils;
import com.knits.tms.test.utils.MockUtils;
import com.knits.tms.util.TmsConsts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeServiceTest {

	@InjectMocks	
	private EmployeeService employeeService;
	
	@Mock
	private EmployeeDao employeeDao;
	
	@Mock
	private RoleDao roleDao;
		
	@Captor
	private ArgumentCaptor<Employee> employeeArgCaptor;
	
	
	
	@Before
	public void init() {	
		employeeService = new EmployeeService();
		MockitoAnnotations.initMocks(this); 	
	}
	
	@Test
	public void testSaveEmployee() {
			
		//given ...
		EmployeeDto employeeDto = MockUtils.mockEmployeeDto();
		Role roleAdmin =MockUtils.mockAdminRole();
		when(roleDao.findByName(TmsConsts.ROLE_USER)).thenReturn(roleAdmin);
		 
		
		//when
		employeeService.saveEmployee(employeeDto);
				
	
		//then 
		Mockito.verify(employeeDao,Mockito.times(1)).save(employeeArgCaptor.capture());
		
		Employee employee =employeeArgCaptor.getValue();
		
		AssertionUtils.assertDto2ModelMapping(employeeDto,employee);
		Assert.assertEquals(1,employee.getRoles().size());			
		Assert.assertTrue(roleAdmin.getName().equals(employee.getRoles().get(0).getName()));		
		
	}
	
	
	
	
	


}
