package com.BikkadIT.RestApiCrudeOperation.service;

import java.util.List;


import com.BikkadIT.RestApiCrudeOperation.entities.Employee;


public interface EmployeeServiceI {

	public Employee saveEmployee(Employee emp);
	public List<Employee> getAllEmployee();
	public Employee getEmployeeByIdPathParam(int id);
	public Employee getEmployeeByIdQueryParam(int id);
	public List<Employee> saveAllEmployee(List<Employee>list);
	public Employee getEmployeeRequestBody(Employee emp);
	public List<Employee> getAgeLessThan(int empAge);
	public Employee updateEmployee(Employee emp);
	public boolean LoginCheck(String email,String password);
	public boolean deleteByEmpId(int id); 
	public boolean deleteAllEmployee();
}
