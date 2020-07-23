package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeDetailsRepository;

// employee service class
@Service
public class EmployeeService {

	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;

	// fetching all employees
	public List<Employee> getAllEmployees() {
		List<Employee> emps = (List<Employee>) employeeDetailsRepository.findAll();
		return emps;
	}

	// fetching employee by id
	public Employee getEmployee(int id) {
		return employeeDetailsRepository.findById(id).get();
	}

	// inserting employee
	public void addEmployee(Employee e) {
		employeeDetailsRepository.save(e);
	}

	// updating employee by id
	public void updateEmployee(Employee emp, int id) {
		if (id == emp.getEmployeeID()) {
			employeeDetailsRepository.save(emp);
		}
	}

	// deleting all employees
	public void deleteAllEmployees() {
		employeeDetailsRepository.deleteAll();
	}

	// deleting employee by id
	public void deleteEmployeeByID(int id) {
		employeeDetailsRepository.deleteById(id);
	}

}
