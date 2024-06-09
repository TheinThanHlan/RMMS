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
public class MenuTemplateController{

	@Autowired()
	MenuTemplateDao dao;

	@PostMapping("createMenuTemplate")
	public String create(
	@RequestBody()
	 MenuTemplate dataMenuTemplate){
		dao.create(dataMenuTemplate);
		return dataMenuTemplate.toJson();

	}

	@PostMapping("readMenuTemplateFromId")
	public String readMenuTemplateFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();

		}
		catch(NullPointerException e){
			return null;

		}

	}

	@PostMapping("readMenuTemplate")
	public String read(
	@RequestBody()
	 MenuTemplate dataMenuTemplate ){
		try{
			return dao.read(dataMenuTemplate).toJson();

		}
		catch(NullPointerException e){
			return null;

		}

	}

	@PostMapping("updateMenuTemplate")
	public void update(
	@RequestBody()
	 MenuTemplate dataMenuTemplate){
		dao.update(dataMenuTemplate);

	}

	@PostMapping("deleteMenuTemplate")
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
	@PostMapping("readAllMenuTemplates")
	public String read(){
		try{
			return new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(dao.readAll());

		}
		catch(NullPointerException e){
			return null;

		}

	}

}
