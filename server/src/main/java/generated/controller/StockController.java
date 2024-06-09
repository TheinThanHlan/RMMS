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
public class StockController{
	
	@Autowired()
	StockDao dao;
	
	@PostMapping("createStock")
	public String create(
	@RequestBody()
	 Stock dataStock){
		dao.create(dataStock);
		return dataStock.toJson();
		
	}
	
	@PostMapping("readStockFromId")
	public String readStockFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readStock")
	public String read(
	@RequestBody()
	 Stock dataStock ){
		try{
			return dao.read(dataStock).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateStock")
	public void update(
	@RequestBody()
	 Stock dataStock){
		dao.update(dataStock);
		
	}
	
	@PostMapping("deleteStock")
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
