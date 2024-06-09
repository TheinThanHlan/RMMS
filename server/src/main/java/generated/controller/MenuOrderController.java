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
public class MenuOrderController {

    @Autowired()
    MenuOrderDao dao;

    @PostMapping("createMenuOrder")
    public String create(
            @RequestBody() MenuOrder dataMenuOrder) {
        dao.create(dataMenuOrder);
        return dataMenuOrder.toJson();

    }

    @PostMapping("readMenuOrderFromId")
    public String readMenuOrderFromId(
            @RequestBody() int id) {
        try {
            return dao.readFromId(id).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("readMenuOrder")
    public String read(
            @RequestBody() MenuOrder dataMenuOrder) {
        try {
            return dao.read(dataMenuOrder).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("updateMenuOrder")
    public void update(
            @RequestBody() MenuOrder dataMenuOrder) {
        dao.update(dataMenuOrder);

    }

    @PostMapping("deleteMenuOrder")
    public String delete(
            @RequestBody() long id) {
        try {
            dao.delete(id);
            return "true";

        } catch (Exception e) {
            return "false";

        }

    }

    @PostMapping("readAllMenuOrders")
    public String readAllMenuOrders(@RequestBody() long voucherId) {
        try {
            return new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                    .toJson(this.dao.readAllMenuOrders(voucherId));
        } catch (NullPointerException e) {
            return null;

        }
    }

}
