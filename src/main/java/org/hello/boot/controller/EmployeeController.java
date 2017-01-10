package org.hello.boot.controller;

import java.util.List;
import org.hello.boot.entity.Employee;
import org.hello.boot.entity.Greeting;
import org.hello.boot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hello")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getAllEmployee", nickname="getAllEmployee")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Greeting.class),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	@RequestMapping(value="/employees/{empno}", method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getEmployeeByID", nickname="getEmployeeByID")
	@ApiImplicitParams({@ApiImplicitParam(name="empno", value="Employee ID", required=true, 
		dataType="Integer", paramType="path")})
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Employee.class, responseContainer="List"),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public Employee getEmployeeByID(@PathVariable Integer empno){
		return employeeRepository.findEmployeeById(empno);
	}
	

}
