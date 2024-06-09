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
public class TypeController {

    @Autowired()
    TypeDao dao;

    @PostMapping("createType")
    public String create(
            @RequestBody() Type dataType) {
        dao.create(dataType);
        return dataType.toJson();

    }

    @PostMapping("readTypeFromId")
    public String readTypeFromId(
            @RequestBody() int id) {
        try {
            return dao.readFromId(id).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("readType")
    public String read(
            @RequestBody() Type dataType) {
        try {
            return dao.read(dataType).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("updateType")
    public void update(
            @RequestBody() Type dataType) {
        dao.update(dataType);

    }

    @PostMapping("deleteType")
    public String delete(
            @RequestBody() long id) {
        try {
            dao.delete(id);
            return "true";

        } catch (Exception e) {
            return "false";

        }

    }

    @PostMapping("readAllTypes")
    public String read() {
        try {
            return new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                    .toJson(dao.readAllTypes());

        } catch (NullPointerException e) {
            return null;

        }

    }

}
