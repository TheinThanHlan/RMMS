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
public class OrderStatusController{
	
	@Autowired()
	OrderStatusDao dao;
	
	@PostMapping("createOrderStatus")
	public String create(
	@RequestBody()
	 OrderStatus dataOrderStatus){
		dao.create(dataOrderStatus);
		return dataOrderStatus.toJson();
		
	}
	
	@PostMapping("readOrderStatusFromId")
	public String readOrderStatusFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readOrderStatus")
	public String read(
	@RequestBody()
	 OrderStatus dataOrderStatus ){
		try{
			return dao.read(dataOrderStatus).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateOrderStatus")
	public void update(
	@RequestBody()
	 OrderStatus dataOrderStatus){
		dao.update(dataOrderStatus);
		
	}
	
	@PostMapping("deleteOrderStatus")
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
