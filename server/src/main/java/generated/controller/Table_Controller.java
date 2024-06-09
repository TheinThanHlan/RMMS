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
public class Table_Controller{

	@Autowired()
	Table_Dao dao;

	@PostMapping("createTable_")
	public String create(
	@RequestBody()
	 Table_ dataTable_){
		dao.create(dataTable_);
		return dataTable_.toJson();

	}

	@PostMapping("readTable_FromId")
	public String readTable_FromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();

		}
		catch(NullPointerException e){
			return null;

		}

	}

	@PostMapping("readTable_")
	public String read(
	@RequestBody()
	 Table_ dataTable_ ){
		try{
			return dao.read(dataTable_).toJson();

		}
		catch(NullPointerException e){
			return null;

		}

	}

	@PostMapping("updateTable_")
	public void update(
	@RequestBody()
	 Table_ dataTable_){
		dao.update(dataTable_);

	}

	@PostMapping("deleteTable_")
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

	@PostMapping("readAllTable_s")
	public String readAll(@RequestBody() long restaurantId){
		try{
			return new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(dao.readAll(restaurantId));
		}
		catch(NullPointerException e){
			return null;

		}

	}
}
