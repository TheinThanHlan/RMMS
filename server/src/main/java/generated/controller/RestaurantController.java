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
public class RestaurantController{
	
	@Autowired()
	RestaurantDao dao;
	
	@PostMapping("createRestaurant")
	public String create(
	@RequestBody()
	 Restaurant dataRestaurant){
		dao.create(dataRestaurant);
		return dataRestaurant.toJson();
		
	}
	
	@PostMapping("readRestaurantFromId")
	public String readRestaurantFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readRestaurant")
	public String read(
	@RequestBody()
	 Restaurant dataRestaurant ){
		try{
			return dao.read(dataRestaurant).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateRestaurant")
	public void update(
	@RequestBody()
	 Restaurant dataRestaurant){
		dao.update(dataRestaurant);
		
	}
	
	@PostMapping("deleteRestaurant")
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
