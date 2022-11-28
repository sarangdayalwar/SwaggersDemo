package com.BikkadIT.RestApiCrudeOperation.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.RestApiCrudeOperation.entities.Employee;
import com.BikkadIT.RestApiCrudeOperation.service.EmployeeServiceI;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceI employeeServiceI;
	
	
	@PostMapping(value = "/saveEmployee", consumes = {"application/xml","application/json"},produces = {"application/xml","application/json"} )
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		  Employee employee = employeeServiceI.saveEmployee(emp);
		
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		
	}
	@GetMapping(value = "/getAllEmployee",produces = {"application/json","application/xml"})
	public ResponseEntity< List<Employee>>getAllEmployee(){
		
		List<Employee> allEmployee = employeeServiceI.getAllEmployee();
		
		return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getEmployeeIdPathParam/{id}",produces = {"application/json"})
	public ResponseEntity<Employee>  getEmployeeIdPathParam(@PathVariable int id){
		
		Employee employee = employeeServiceI.getEmployeeByIdPathParam(id);
		
		return new  ResponseEntity<Employee>(employee,HttpStatus.OK);
		
	}
	@GetMapping(value="/getEmployeeIdQueryParam",produces = {"application/json"})
	public ResponseEntity<Employee>  getEmployeeIdQueryParam(@RequestParam int id){
		
		Employee employee = employeeServiceI.getEmployeeByIdQueryParam(id);
		
		return new  ResponseEntity<Employee>(employee,HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/saveAllEmployee", consumes = {"application/json" }, produces = {"application/json"})
	public ResponseEntity<List<Employee>> saveAllEmployee(@RequestBody List<Employee> list) {

		System.out.println(list);
		List<Employee> saveAllEmployee = employeeServiceI.saveAllEmployee(list);

		return new ResponseEntity<List<Employee>>(saveAllEmployee, HttpStatus.CREATED);
	
	}


	@GetMapping(value="/getEmployeeIdRequestBody",produces = {"application/json"})
	public ResponseEntity<Employee>  getEmployeeIdRequestBody(@RequestBody Employee emp){
		
		System.out.println(emp);
		Employee employee = employeeServiceI.getEmployeeRequestBody(emp);
		
		return new  ResponseEntity<Employee>(employee,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getEmpAgeLessThan/{empAge}",produces = "application/json")
	public ResponseEntity<List<Employee>> getEmpAgeLessThan(@PathVariable int empAge){
		List<Employee> list = employeeServiceI.getAgeLessThan(empAge);
		
		return  new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	
}
	
	@PutMapping(value = "/updateEmployee", consumes = {"application/json" }, produces = {"application/json"})
	public ResponseEntity< Employee> updateEmployee(@RequestBody Employee emp){
		Employee employee = employeeServiceI.updateEmployee(emp);
		
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	
}
	
	@GetMapping(value = "/loginCheck/{empEmail}/{password}")
	public ResponseEntity< String> loginCheck(@PathVariable String empEmail,@PathVariable String password){
		boolean loginCheck = employeeServiceI.LoginCheck(empEmail, password);
		if(loginCheck ) {
			String msg="Login Succesfully";
	return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			String msg1="Login UnSuccesfull";
		return new ResponseEntity<String>(msg1,HttpStatus.OK);
	
		}
	}
	@DeleteMapping("/deleteEmployeeById/{empId}")
	public ResponseEntity< String> deleteEmployeeById(@PathVariable int empId){
		boolean deleteByEmpId = employeeServiceI.deleteByEmpId(empId);
		if (deleteByEmpId) {
			return new ResponseEntity<String>("Id deleted",HttpStatus.OK);
	}else {
		
	
		return  new ResponseEntity<String>("Id not deleted",HttpStatus.OK);
	
	}
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity< String> deleteAll(){
		boolean deleteEmpById = employeeServiceI.deleteAllEmployee();
		if (deleteEmpById) {
			return new ResponseEntity<String>("All emp deleted",HttpStatus.OK);
			
		}else {
			return new ResponseEntity<String>("Employees not deleted",HttpStatus.OK);
		}
	
	}
	

}
