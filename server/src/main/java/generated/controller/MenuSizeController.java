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
public class MenuSizeController{

	@Autowired()
	MenuSizeDao dao;

	@PostMapping("createMenuSize")
	public String create(
	@RequestBody()
	 MenuSize dataMenuSize){
		dao.create(dataMenuSize);
		return dataMenuSize.toJson();

	}

	@PostMapping("readMenuSizeFromId")
	public String readMenuSizeFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();

		}
		catch(NullPointerException e){
			return null;

		}

	}

	@PostMapping("readMenuSize")
	public String read(
	@RequestBody()
	 MenuSize dataMenuSize ){
		try{
			return dao.read(dataMenuSize).toJson();

		}
		catch(NullPointerException e){
			return null;

		}

	}

	@PostMapping("updateMenuSize")
	public void update(
	@RequestBody()
	 MenuSize dataMenuSize){
		dao.update(dataMenuSize);

	}

	@PostMapping("deleteMenuSize")
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

	@PostMapping("readAllMenuSizes")
	public String read(){
		try{
			return new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(dao.readAll());

		}
		catch(NullPointerException e){
			return null;

		}

	}

}
