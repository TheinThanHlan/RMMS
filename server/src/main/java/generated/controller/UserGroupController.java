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
public class UserGroupController {

    @Autowired()
    UserGroupDao dao;

    @PostMapping("createUserGroup")
    public String create(
            @RequestBody() UserGroup dataUserGroup) {
        dao.create(dataUserGroup);
        return dataUserGroup.toJson();

    }

    @PostMapping("readUserGroupFromId")
    public String readUserGroupFromId(
            @RequestBody() int id) {
        try {
            return dao.readFromId(id).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("readUserGroup")
    public String read(
            @RequestBody() UserGroup dataUserGroup) {
        try {
            return dao.read(dataUserGroup).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("updateUserGroup")
    public void update(
            @RequestBody() UserGroup dataUserGroup) {
        dao.update(dataUserGroup);

    }

    @PostMapping("deleteUserGroup")
    public String delete(
            @RequestBody() long id) {
        try {
            dao.delete(id);
            return "true";

        } catch (Exception e) {
            return "false";

        }

    }

    @PostMapping("readAllUserGroupsOfType")
    public String readAllUserGroupsOfType(
            @RequestBody() long id) {
        try {
            return new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                    .toJson(dao.readAllUserGroupsOfType(id));

        } catch (NullPointerException e) {
            return null;

        }

    }

}
