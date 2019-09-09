package com.centric.employee;

class EmployeeNotFoundException extends RuntimeException {

	EmployeeNotFoundException(Long id) {
		super("Could not find com.centric.employee " + id);
	}
}
