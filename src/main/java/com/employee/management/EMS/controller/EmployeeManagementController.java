package com.employee.management.EMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.EMS.model.Employee;
import com.employee.management.EMS.model.EmployeeErrorResponse;
import com.employee.management.EMS.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class EmployeeManagementController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	
    // get by id
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {

        return ResponseEntity.ok(employeeService.getEmployeeById(id));

    }
	
    // get all
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());

    }
	
	// create
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
       try {
		return new ResponseEntity<Object>( employeeService.createEmployee(employee), HttpStatus.CREATED);
	   } catch (Exception e) {
			EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
    }
    
    // Edit
    @PutMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> editEmployee(@RequestBody Employee employee) {
       return new ResponseEntity<Employee>( employeeService.editEmployee(employee), HttpStatus.CREATED);
    }
    
    // Remove
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> removeEmployee(@PathVariable("id") int employeeId) {
    	System.out.println("Delete called");
       return new ResponseEntity<>( employeeService.deleteEmployee(employeeId), HttpStatus.OK);
    }
}
