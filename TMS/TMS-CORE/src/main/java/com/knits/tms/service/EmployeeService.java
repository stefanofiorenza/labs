package com.knits.tms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.knits.tms.beans.EmployeeDto;
import com.knits.tms.dao.EmployeeDao;
import com.knits.tms.dao.RoleDao;
import com.knits.tms.model.Employee;
import com.knits.tms.model.Role;
import com.knits.tms.util.BeanMappingUtils;
import com.knits.tms.util.TmsConsts;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private RoleDao roleDao;
	
	public void saveEmployee(EmployeeDto employeeDto) {		
		Employee employeeAsModel= BeanMappingUtils.dto2Model(employeeDto);
		Role role =roleDao.findByName(TmsConsts.ROLE_USER);
		employeeAsModel.getRoles().add(role);		
		employeeDao.save(employeeAsModel);		
	}
}
