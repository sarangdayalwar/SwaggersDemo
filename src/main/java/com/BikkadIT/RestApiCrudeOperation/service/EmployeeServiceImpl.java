package com.BikkadIT.RestApiCrudeOperation.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.RestApiCrudeOperation.entities.Employee;
import com.BikkadIT.RestApiCrudeOperation.repository.EmployeeRepository;

@Service
public  class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee emp) {
	Employee save = employeeRepository.save(emp);
		return save;
	}

	@Override
	public List<Employee> getAllEmployee() {
	List<Employee> findAll=employeeRepository.findAll();
		return findAll ;
	}

	@Override
	public Employee getEmployeeByIdPathParam(int id) {
		Employee  findById = employeeRepository.findById( id).get();
		return  findById;
	}

	@Override
	public Employee getEmployeeByIdQueryParam(int id) {
		Employee findById = employeeRepository.findById( id).get();
		return  findById;
	}

	@Override
	public List<Employee> saveAllEmployee(List<Employee> list) {
		List<Employee> saveAll = employeeRepository.saveAll( list);
		return  saveAll;
	}

	@Override
	public Employee getEmployeeRequestBody(Employee emp) {
		int empId=emp.getEmpId();
		Employee emp1 = employeeRepository.findById( empId).get();
		return  emp1;
	}

	@Override
	public List<Employee> getAgeLessThan(int empAge) {
		List<Employee>  list = employeeRepository.findByEmpAgeLessThan(empAge);
		return  list;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Employee save = employeeRepository.save(emp );
		return  save;
	}

	@Override
	public boolean LoginCheck(String email, String password) {
		Employee  emp = employeeRepository.findByEmpEmailAndPassword(email, password);
		if(emp !=null) {
		
		return true ;
	}else
		return   false;
	}

	@Override
	public boolean deleteByEmpId(int id) {
		boolean existsById = employeeRepository.existsById( id);
		if (existsById) {
		employeeRepository.deleteById(id);
		return  true;
	}else {
		return false;
	

	}

	}
	@Override
	public boolean deleteAllEmployee() {
		List<Employee> findAll = employeeRepository.findAll();
		if(findAll !=null) {
			employeeRepository.deleteAll();
		
		return  true;
	}else {
		return false;
		 
	}}}