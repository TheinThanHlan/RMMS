
package dao;

import bean.Category;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Category.properties")
@Component()
public class CategoryDao {
    @Autowired()
    SessionFactory sf;

    public void create(Category data) {
        Session s = this.sf.openSession();
        try {
            Transaction tx = s.beginTransaction();
            s.save(data);
            tx.commit();

        } finally {
            s.close();
        }
    }

    public Category readFromId(long id) {
        Session s = this.sf.openSession();
        Category tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<Category>get(Category.class, id);
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public Category read(Category obj) {
        Session s = this.sf.openSession();
        Category tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<Category>get(Category.class, obj.getId());
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public void update(Category data) {
        Session s = this.sf.openSession();
        try {
            Transaction t = s.beginTransaction();
            s.persist(data);
            t.commit();

        } finally {
            s.close();
        }
    }

    public void delete(long id) {
        Session s = this.sf.openSession();
        try {
            Transaction t = s.beginTransaction();
            s.remove(this.readFromId(id));
            t.commit();

        } finally {
            s.close();
        }
    }

    public java.util.List<Category> readAllCategories(long typeId) {
        Session s = this.sf.openSession();
        java.util.List<Category> tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            jakarta.persistence.Query query = s.createQuery("FROM  Category c where c.type.id = " + typeId);

            tmp = query.getResultList();

            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

}
