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
public class GenderController{
	
	@Autowired()
	GenderDao dao;
	
	@PostMapping("createGender")
	public String create(
	@RequestBody()
	 Gender dataGender){
		dao.create(dataGender);
		return dataGender.toJson();
		
	}
	
	@PostMapping("readGenderFromId")
	public String readGenderFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readGender")
	public String read(
	@RequestBody()
	 Gender dataGender ){
		try{
			return dao.read(dataGender).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateGender")
	public void update(
	@RequestBody()
	 Gender dataGender){
		dao.update(dataGender);
		
	}
	
	@PostMapping("deleteGender")
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
