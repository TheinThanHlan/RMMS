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
public class PageController{
	
	@Autowired()
	PageDao dao;
	
	@PostMapping("createPage")
	public String create(
	@RequestBody()
	 Page dataPage){
		dao.create(dataPage);
		return dataPage.toJson();
		
	}
	
	@PostMapping("readPageFromId")
	public String readPageFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readPage")
	public String read(
	@RequestBody()
	 Page dataPage ){
		try{
			return dao.read(dataPage).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updatePage")
	public void update(
	@RequestBody()
	 Page dataPage){
		dao.update(dataPage);
		
	}
	
	@PostMapping("deletePage")
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
