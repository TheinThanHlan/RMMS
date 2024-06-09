package controller;

import com.google.gson.GsonBuilder;
import gson.custom.ExcludeVars;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import dao.*;
import bean.*;

@RestController()
public class MenuController {

    @Autowired()
    MenuDao dao;

    @PostMapping("createMenu")
    public String create(
            @RequestBody() Menu dataMenu) {
        dao.create(dataMenu);
        return dataMenu.toJson();

    }

    @PostMapping("readMenuFromId")
    public String readMenuFromId(
            @RequestBody() int id) {
        try {
            return dao.readFromId(id).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("readMenu")
    public String read(
            @RequestBody() Menu dataMenu) {
        try {
            return dao.read(dataMenu).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("updateMenu")
    public void update(
            @RequestBody() Menu dataMenu) {
        dao.update(dataMenu);

    }

    @PostMapping("deleteMenu")
    public String delete(
            @RequestBody() long id) {
        try {
            dao.delete(id);
            return "true";

        } catch (Exception e) {
            return "false";

        }

    }

    @PostMapping("readAllMenus")
    public String readAll(@RequestBody() long restaurantId) {
        try {
            return new com.google.gson.GsonBuilder()
                    .setExclusionStrategies(new ExcludeVars(new String[] { "menuPrices" })).create()
                    .toJson(dao.readAll(restaurantId));
        } catch (NullPointerException e) {
            return null;

        }

    }

}
