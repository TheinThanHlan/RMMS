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
public class DeliveryController{
	
	@Autowired()
	DeliveryDao dao;
	
	@PostMapping("createDelivery")
	public String create(
	@RequestBody()
	 Delivery dataDelivery){
		dao.create(dataDelivery);
		return dataDelivery.toJson();
		
	}
	
	@PostMapping("readDeliveryFromId")
	public String readDeliveryFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readDelivery")
	public String read(
	@RequestBody()
	 Delivery dataDelivery ){
		try{
			return dao.read(dataDelivery).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateDelivery")
	public void update(
	@RequestBody()
	 Delivery dataDelivery){
		dao.update(dataDelivery);
		
	}
	
	@PostMapping("deleteDelivery")
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
