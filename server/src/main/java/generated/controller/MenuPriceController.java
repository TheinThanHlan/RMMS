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
public class MenuPriceController{
	
	@Autowired()
	MenuPriceDao dao;
	
	@PostMapping("createMenuPrice")
	public String create(
	@RequestBody()
	 MenuPrice dataMenuPrice){
		dao.create(dataMenuPrice);
		return dataMenuPrice.toJson();
		
	}
	
	@PostMapping("readMenuPriceFromId")
	public String readMenuPriceFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readMenuPrice")
	public String read(
	@RequestBody()
	 MenuPrice dataMenuPrice ){
		try{
			return dao.read(dataMenuPrice).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateMenuPrice")
	public void update(
	@RequestBody()
	 MenuPrice dataMenuPrice){
		dao.update(dataMenuPrice);
		
	}
	
	@PostMapping("deleteMenuPrice")
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
