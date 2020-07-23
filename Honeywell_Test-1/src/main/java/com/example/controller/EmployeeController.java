package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping(value = "/rest/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		try {
			return employeeService.getAllEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// displaying employee by id
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		if (id == null) {
			System.out.println("No ID available");
		} else
			return employeeService.getEmployee(id);

		return null;
	}

	// inserting employee
	@PostMapping("/employees")
	public void addEmployees(@RequestBody Employee employee) {
		try {
			employeeService.addEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// updating employee by id
	@PutMapping("/employees/{id}")
	public void updateEmployee(@RequestBody Employee e, @PathVariable Integer id) {
		if (e != null && id != null)
			employeeService.updateEmployee(e, id);
		else
			System.out.println("No data to update");

	}

	// deleting all employees
	@DeleteMapping("/employees")
	public void deleteAllEmployees() {
		try {
			employeeService.deleteAllEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// deleting employee by id
	@DeleteMapping("employees/{id}")
	public void deleteEmployeeByID(@RequestBody Employee e, @PathVariable Integer id) {
		if (e != null && id != null)
			employeeService.deleteEmployeeByID(id);
	}

}
