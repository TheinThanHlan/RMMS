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
public class StockOrderStatusController{
	
	@Autowired()
	StockOrderStatusDao dao;
	
	@PostMapping("createStockOrderStatus")
	public String create(
	@RequestBody()
	 StockOrderStatus dataStockOrderStatus){
		dao.create(dataStockOrderStatus);
		return dataStockOrderStatus.toJson();
		
	}
	
	@PostMapping("readStockOrderStatusFromId")
	public String readStockOrderStatusFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readStockOrderStatus")
	public String read(
	@RequestBody()
	 StockOrderStatus dataStockOrderStatus ){
		try{
			return dao.read(dataStockOrderStatus).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateStockOrderStatus")
	public void update(
	@RequestBody()
	 StockOrderStatus dataStockOrderStatus){
		dao.update(dataStockOrderStatus);
		
	}
	
	@PostMapping("deleteStockOrderStatus")
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
