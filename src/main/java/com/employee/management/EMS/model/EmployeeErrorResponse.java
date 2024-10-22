package com.employee.management.EMS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class EmployeeErrorResponse {

	public EmployeeErrorResponse(String message, int value) {
		this.message = message;
		this.errorCode = value;
	}
	String message;
	int errorCode;
}
