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
public class CategoryController {

    @Autowired()
    CategoryDao dao;

    @PostMapping("createCategory")
    public String create(
            @RequestBody() Category dataCategory) {
        dao.create(dataCategory);
        return dataCategory.toJson();

    }

    @PostMapping("readCategoryFromId")
    public String readCategoryFromId(
            @RequestBody() int id) {
        try {
            return dao.readFromId(id).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("readCategory")
    public String read(
            @RequestBody() Category dataCategory) {
        try {
            return dao.read(dataCategory).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("updateCategory")
    public void update(
            @RequestBody() Category dataCategory) {
        dao.update(dataCategory);

    }

    @PostMapping("deleteCategory")
    public String delete(
            @RequestBody() long id) {
        try {
            dao.delete(id);
            return "true";

        } catch (Exception e) {
            return "false";

        }

    }

    @PostMapping("readAllCategories")
    public String readAllCategories(@RequestBody() long typeId) {
        try {
            return new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                    .toJson(dao.readAllCategories(typeId));
        } catch (NullPointerException e) {
            return null;

        }

    }
}
