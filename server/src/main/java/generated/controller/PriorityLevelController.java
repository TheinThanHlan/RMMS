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
public class PriorityLevelController{
	
	@Autowired()
	PriorityLevelDao dao;
	
	@PostMapping("createPriorityLevel")
	public String create(
	@RequestBody()
	 PriorityLevel dataPriorityLevel){
		dao.create(dataPriorityLevel);
		return dataPriorityLevel.toJson();
		
	}
	
	@PostMapping("readPriorityLevelFromId")
	public String readPriorityLevelFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readPriorityLevel")
	public String read(
	@RequestBody()
	 PriorityLevel dataPriorityLevel ){
		try{
			return dao.read(dataPriorityLevel).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updatePriorityLevel")
	public void update(
	@RequestBody()
	 PriorityLevel dataPriorityLevel){
		dao.update(dataPriorityLevel);
		
	}
	
	@PostMapping("deletePriorityLevel")
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
