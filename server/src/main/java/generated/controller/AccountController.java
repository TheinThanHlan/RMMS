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
public class AccountController{
	
	@Autowired()
	AccountDao dao;
	
	@PostMapping("createAccount")
	public String create(
	@RequestBody()
	 Account dataAccount){
		dao.create(dataAccount);
		return dataAccount.toJson();
		
	}
	
	@PostMapping("readAccountFromId")
	public String readAccountFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readAccount")
	public String read(
	@RequestBody()
	 Account dataAccount ){
		try{
			return dao.read(dataAccount).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateAccount")
	public void update(
	@RequestBody()
	 Account dataAccount){
		dao.update(dataAccount);
		
	}
	
	@PostMapping("deleteAccount")
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
