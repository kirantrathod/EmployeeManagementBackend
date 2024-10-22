package com.employee.management.EMS.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.employee.management.EMS.model.Employee;

@Repository
public class EmployeeRepository {
	List<Employee> employeeList = new ArrayList<>();
	
	public Employee createEmployee(Employee employee) throws Exception{
		
		Employee duplicateEmployee = employeeList.stream()
				  .filter(e -> employee.employeeId == e.employeeId)
				  .findAny()
				  .orElse(null);
		if(duplicateEmployee == null) {
			employeeList.add(employee);
			return employee;
		}else {
			throw new Exception("Employee with same employee ID is present");
		}
		
	}
	
	public List<Employee> getEmployees(){
		return employeeList;
	}
	
	public Employee getEmployeebyId(int id){
		Employee employee = employeeList.stream().filter(e-> e.employeeId ==id).findFirst().orElse(null);
		return employee;
	}
	
	public Employee editEmployee(Employee employee) {
		int index = employeeList.stream()
			    .map(e -> e.employeeId)
			    .collect(Collectors.toList())
			    .indexOf(employee.employeeId);
		employeeList.set(index,employee);
		return employee;
	}
	
	public boolean deleteEmployee(int employeeId) {
		int index = employeeList.stream()
			    .map(e -> e.employeeId)
			    .collect(Collectors.toList())
			    .indexOf(employeeId);
		Employee emp = employeeList.remove(index);
		if(emp != null) {
			return true;
		}
		return false;
	}
	
}
