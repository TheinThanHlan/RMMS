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
public class StateController {

    @Autowired()
    StateDao dao;

    @PostMapping("createState")
    public String create(
            @RequestBody() State dataState) {
        dao.create(dataState);
        return dataState.toJson();

    }

    @PostMapping("readStateFromId")
    public String readStateFromId(
            @RequestBody() int id) {
        try {
            return dao.readFromId(id).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("readState")
    public String read(
            @RequestBody() State dataState) {
        try {
            return dao.read(dataState).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("updateState")
    public void update(
            @RequestBody() State dataState) {
        dao.update(dataState);

    }

    @PostMapping("deleteState")
    public String delete(
            @RequestBody() long id) {
        try {
            dao.delete(id);
            return "true";

        } catch (Exception e) {
            return "false";

        }

    }

    @PostMapping("readAllStatesOfType")
    public String readAllStatesOfType(@RequestBody() long typeId) {
        try {
            return new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                    .toJson(dao.readAllStatesOfType(typeId));

        } catch (NullPointerException e) {
            return null;

        }

    }

}
