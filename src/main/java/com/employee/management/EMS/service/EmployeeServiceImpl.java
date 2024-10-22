package com.employee.management.EMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.EMS.model.Employee;
import com.employee.management.EMS.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getEmployees();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.getEmployeebyId(id);
	}

	@Override
	public Employee createEmployee(Employee employee) throws Exception{
		
	  return employeeRepository.createEmployee(employee);
		 
	}

	@Override
	public Employee editEmployee(Employee employee) {
		
		return employeeRepository.editEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		
		return employeeRepository.deleteEmployee(employeeId);
	}

}
