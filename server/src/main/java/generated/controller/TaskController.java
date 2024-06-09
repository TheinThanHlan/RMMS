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
public class TaskController {

    @Autowired()
    TaskDao dao;

    @PostMapping("createTask")
    public String create(
            @RequestBody() Task dataTask) {
        dao.create(dataTask);
        return dataTask.toJson();

    }

    @PostMapping("readTaskFromId")
    public String readTaskFromId(
            @RequestBody() int id) {
        try {
            return dao.readFromId(id).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("readTask")
    public String read(
            @RequestBody() Task dataTask) {
        try {
            return dao.read(dataTask).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("updateTask")
    public void update(
            @RequestBody() Task dataTask) {
        dao.update(dataTask);

    }

    @PostMapping("deleteTask")
    public String delete(
            @RequestBody() long id) {
        try {
            dao.delete(id);
            return "true";

        } catch (Exception e) {
            return "false";

        }

    }

}
