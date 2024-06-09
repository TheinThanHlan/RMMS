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
public class StockSupplierController{
	
	@Autowired()
	StockSupplierDao dao;
	
	@PostMapping("createStockSupplier")
	public String create(
	@RequestBody()
	 StockSupplier dataStockSupplier){
		dao.create(dataStockSupplier);
		return dataStockSupplier.toJson();
		
	}
	
	@PostMapping("readStockSupplierFromId")
	public String readStockSupplierFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readStockSupplier")
	public String read(
	@RequestBody()
	 StockSupplier dataStockSupplier ){
		try{
			return dao.read(dataStockSupplier).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateStockSupplier")
	public void update(
	@RequestBody()
	 StockSupplier dataStockSupplier){
		dao.update(dataStockSupplier);
		
	}
	
	@PostMapping("deleteStockSupplier")
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
