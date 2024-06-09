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
public class CustomerController{
	
	@Autowired()
	CustomerDao dao;
	
	@PostMapping("createCustomer")
	public String create(
	@RequestBody()
	 Customer dataCustomer){
		dao.create(dataCustomer);
		return dataCustomer.toJson();
		
	}
	
	@PostMapping("readCustomerFromId")
	public String readCustomerFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readCustomer")
	public String read(
	@RequestBody()
	 Customer dataCustomer ){
		try{
			return dao.read(dataCustomer).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateCustomer")
	public void update(
	@RequestBody()
	 Customer dataCustomer){
		dao.update(dataCustomer);
		
	}
	
	@PostMapping("deleteCustomer")
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
