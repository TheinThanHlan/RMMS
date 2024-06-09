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
public class OrderTypeController{

	@Autowired()
	OrderTypeDao dao;

	@PostMapping("createOrderType")
	public String create(
	@RequestBody()
	 OrderType dataOrderType){
		dao.create(dataOrderType);
		return dataOrderType.toJson();

	}

	@PostMapping("readOrderTypeFromId")
	public String readOrderTypeFromId(
	@RequestBody()
	 int id){
		try{
			return dao.readFromId(id).toJson();

		}
		catch(NullPointerException e){
			return null;

		}

	}

	@PostMapping("readOrderType")
	public String read(
	@RequestBody()
	 OrderType dataOrderType ){
		try{
			return dao.read(dataOrderType).toJson();

		}
		catch(NullPointerException e){
			return null;

		}

	}

	@PostMapping("updateOrderType")
	public void update(
	@RequestBody()
	 OrderType dataOrderType){
		dao.update(dataOrderType);

	}

	@PostMapping("deleteOrderType")
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


	@PostMapping("readAllOrderTypes")
	public String readAllOrderTypes(){
		try{
			return new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                .toJson(this.dao.readAllOrderTypes());
		}
		catch(NullPointerException e){
			return null;

		}
	}
}
