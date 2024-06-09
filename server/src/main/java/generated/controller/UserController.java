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
public class UserController {

    @Autowired()
    UserDao dao;

    @PostMapping("createUser")
    public String create(
            @RequestBody() User dataUser) {
        dao.create(dataUser);
        return dataUser.toJson();

    }

    @PostMapping("readUserFromId")
    public String readUserFromId(
            @RequestBody() int id) {
        try {
            return dao.readFromId(id).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("readUser")
    public String read(
            @RequestBody() User dataUser) {
        try {
            return dao.read(dataUser).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("updateUser")
    public void update(
            @RequestBody() User dataUser) {
        dao.update(dataUser);

    }

    @PostMapping("deleteUser")
    public String delete(
            @RequestBody() long id) {
        try {
            dao.delete(id);
            return "true";

        } catch (Exception e) {
            return "false";

        }

    }

    @PostMapping("login")
    public String login(
            @RequestBody() User dataUser) {
        try {
            return dao.readUserFromUserNameAndPassword(dataUser).toJson();
        } catch (jakarta.persistence.NoResultException e) {
            return "";
        }
    }

}
