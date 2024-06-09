
package dao;

import bean.Menu;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Menu.properties")
@Component()
public class MenuDao {
    @Autowired()
    SessionFactory sf;

    public void create(Menu data) {
        Session s = this.sf.openSession();
        try {
            Transaction tx = s.beginTransaction();
            s.save(data);
            tx.commit();

        } finally {
            s.close();
        }
    }

    public Menu readFromId(long id) {
        Session s = this.sf.openSession();
        Menu tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<Menu>get(Menu.class, id);
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public Menu read(Menu obj) {
        Session s = this.sf.openSession();
        Menu tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<Menu>get(Menu.class, obj.getId());
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public void update(Menu data) {
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
            jakarta.persistence.Query query = s.createQuery("delete MenuPrice mp where mp.menu.id =" + id);
            query.executeUpdate();
            s.remove(this.readFromId(id));
            t.commit();

        } finally {
            s.close();
        }
    }

    public java.util.List<Menu> readAll(long restaurantId) {
        Session s = this.sf.openSession();
        java.util.List<Menu> tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            jakarta.persistence.Query query = s
                    .createQuery("FROM Menu m inner join fetch m.menuPrices p where p.restaurant.id=" + restaurantId
                            + " and p.rowCreatedDateTime = (select MAX(p1.rowCreatedDateTime) from MenuPrice p1 where p1.restaurant.id= "
                            + restaurantId + " and p1.menu.id= m.id )   ");
            tmp = query.getResultList();
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

}
