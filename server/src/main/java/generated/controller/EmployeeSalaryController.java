package controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import dao.*;
import bean.*;

@RestController()
public class EmployeeSalaryController{
	
	@Autowired()
	EmployeeSalaryDao dao;
	
	@PostMapping("createEmployeeSalary")
	public String create(
	@RequestBody()
	 EmployeeSalary dataEmployeeSalary){
		dao.create(dataEmployeeSalary);
		return dataEmployeeSalary.toJson();
		
	}
	
	@PostMapping("readEmployeeSalaryFromId")
	public String readEmployeeSalaryFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readEmployeeSalary")
	public String read(
	@RequestBody()
	 EmployeeSalary dataEmployeeSalary ){
		try{
			return dao.read(dataEmployeeSalary).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateEmployeeSalary")
	public void update(
	@RequestBody()
	 EmployeeSalary dataEmployeeSalary){
		dao.update(dataEmployeeSalary);
		
	}
	
	@PostMapping("deleteEmployeeSalary")
	public String delete(
	@RequestBody()
	 long id){
		try{
			dao.delete(id);
			return "true";
			
		}
		catch(Exception e){
			return "false";
			
		}
		
	}
	
}
