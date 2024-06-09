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
public class EmployeeController {

    @Autowired()
    EmployeeDao dao;

    @PostMapping("createEmployee")
    public String create(
            @RequestBody() Employee dataEmployee) {
        dao.create(dataEmployee);
        return dataEmployee.toJson();

    }

    @PostMapping("readEmployeeFromId")
    public String readEmployeeFromId(
            @RequestBody() int id) {
        try {
            return dao.readFromId(id).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("readEmployee")
    public String read(
            @RequestBody() Employee dataEmployee) {
        try {
            return dao.read(dataEmployee).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("updateEmployee")
    public void update(
            @RequestBody() Employee dataEmployee) {
        dao.update(dataEmployee);

    }

    @PostMapping("deleteEmployee")
    public String delete(
            @RequestBody() long id) {
        try {
            dao.delete(id);
            return "true";

        } catch (Exception e) {
            return "false";

        }

    }

    @PostMapping("readAllEmployees")
    public String readAllEmployees(@RequestBody() long restaurantId) {
        try {
            return new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                    .toJson(dao.readAllEmployees(restaurantId));
        } catch (NullPointerException e) {
            return null;

        }

    }

}
