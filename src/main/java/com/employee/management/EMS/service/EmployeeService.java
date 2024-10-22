package com.employee.management.EMS.service;

import java.util.List;

import com.employee.management.EMS.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee createEmployee(Employee employee) throws Exception;
    
    Employee editEmployee(Employee employee);
    
    boolean deleteEmployee(int employeeId);
}
