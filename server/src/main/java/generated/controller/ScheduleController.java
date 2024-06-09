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
public class ScheduleController{
	
	@Autowired()
	ScheduleDao dao;
	
	@PostMapping("createSchedule")
	public String create(
	@RequestBody()
	 Schedule dataSchedule){
		dao.create(dataSchedule);
		return dataSchedule.toJson();
		
	}
	
	@PostMapping("readScheduleFromId")
	public String readScheduleFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readSchedule")
	public String read(
	@RequestBody()
	 Schedule dataSchedule ){
		try{
			return dao.read(dataSchedule).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateSchedule")
	public void update(
	@RequestBody()
	 Schedule dataSchedule){
		dao.update(dataSchedule);
		
	}
	
	@PostMapping("deleteSchedule")
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
