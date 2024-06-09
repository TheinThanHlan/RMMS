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
public class AuthorityController{
	
	@Autowired()
	AuthorityDao dao;
	
	@PostMapping("createAuthority")
	public String create(
	@RequestBody()
	 Authority dataAuthority){
		dao.create(dataAuthority);
		return dataAuthority.toJson();
		
	}
	
	@PostMapping("readAuthorityFromId")
	public String readAuthorityFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("readAuthority")
	public String read(
	@RequestBody()
	 Authority dataAuthority ){
		try{
			return dao.read(dataAuthority).toJson();
			
		}
		catch(NullPointerException e){
			return null;
			
		}
		
	}
	
	@PostMapping("updateAuthority")
	public void update(
	@RequestBody()
	 Authority dataAuthority){
		dao.update(dataAuthority);
		
	}
	
	@PostMapping("deleteAuthority")
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
