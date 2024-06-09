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
public class MarstaController{
	
	@Autowired()
	MarstaDao dao;
	
	@PostMapping("createMarsta")
	public String create(
	@RequestBody()
	 Marsta dataMarsta){
		dao.create(dataMarsta);
		return dataMarsta.toJson();
		
	}
	
	@PostMapping("readMarstaFromId")
	public String readMarstaFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readMarsta")
	public String read(
	@RequestBody()
	 Marsta dataMarsta ){
		try{
			return dao.read(dataMarsta).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateMarsta")
	public void update(
	@RequestBody()
	 Marsta dataMarsta){
		dao.update(dataMarsta);
		
	}
	
	@PostMapping("deleteMarsta")
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
