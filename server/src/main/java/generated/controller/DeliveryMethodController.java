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
public class DeliveryMethodController{
	
	@Autowired()
	DeliveryMethodDao dao;
	
	@PostMapping("createDeliveryMethod")
	public String create(
	@RequestBody()
	 DeliveryMethod dataDeliveryMethod){
		dao.create(dataDeliveryMethod);
		return dataDeliveryMethod.toJson();
		
	}
	
	@PostMapping("readDeliveryMethodFromId")
	public String readDeliveryMethodFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readDeliveryMethod")
	public String read(
	@RequestBody()
	 DeliveryMethod dataDeliveryMethod ){
		try{
			return dao.read(dataDeliveryMethod).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateDeliveryMethod")
	public void update(
	@RequestBody()
	 DeliveryMethod dataDeliveryMethod){
		dao.update(dataDeliveryMethod);
		
	}
	
	@PostMapping("deleteDeliveryMethod")
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
