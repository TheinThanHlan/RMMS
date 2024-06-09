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
public class AccountTransactionController{
	
	@Autowired()
	AccountTransactionDao dao;
	
	@PostMapping("createAccountTransaction")
	public String create(
	@RequestBody()
	 AccountTransaction dataAccountTransaction){
		dao.create(dataAccountTransaction);
		return dataAccountTransaction.toJson();
		
	}
	
	@PostMapping("readAccountTransactionFromId")
	public String readAccountTransactionFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readAccountTransaction")
	public String read(
	@RequestBody()
	 AccountTransaction dataAccountTransaction ){
		try{
			return dao.read(dataAccountTransaction).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateAccountTransaction")
	public void update(
	@RequestBody()
	 AccountTransaction dataAccountTransaction){
		dao.update(dataAccountTransaction);
		
	}
	
	@PostMapping("deleteAccountTransaction")
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
