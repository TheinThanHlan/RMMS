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
public class StockOrderController{
	
	@Autowired()
	StockOrderDao dao;
	
	@PostMapping("createStockOrder")
	public String create(
	@RequestBody()
	 StockOrder dataStockOrder){
		dao.create(dataStockOrder);
		return dataStockOrder.toJson();
		
	}
	
	@PostMapping("readStockOrderFromId")
	public String readStockOrderFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readStockOrder")
	public String read(
	@RequestBody()
	 StockOrder dataStockOrder ){
		try{
			return dao.read(dataStockOrder).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateStockOrder")
	public void update(
	@RequestBody()
	 StockOrder dataStockOrder){
		dao.update(dataStockOrder);
		
	}
	
	@PostMapping("deleteStockOrder")
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
