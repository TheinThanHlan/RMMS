
package dao;

import bean.MenuOrder;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/MenuOrder.properties")
@Component()
public class MenuOrderDao {
    @Autowired()
    SessionFactory sf;

    public void create(MenuOrder data) {
        Session s = this.sf.openSession();
        try {
            Transaction tx = s.beginTransaction();
            s.save(data);
            tx.commit();

        } finally {
            s.close();
        }
    }

    public MenuOrder readFromId(long id) {
        Session s = this.sf.openSession();
        MenuOrder tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<MenuOrder>get(MenuOrder.class, id);
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public MenuOrder read(MenuOrder obj) {
        Session s = this.sf.openSession();
        MenuOrder tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<MenuOrder>get(MenuOrder.class, obj.getId());
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public void update(MenuOrder data) {
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

    public java.util.List<MenuOrder> readAllMenuOrders(long voucherId) {
        Session s = this.sf.openSession();
        java.util.List<MenuOrder> tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            jakarta.persistence.Query query = s
                    .createQuery("from MenuOrder o where o.voucher.id=" + voucherId);

            tmp = query.getResultList();
            tx.commit();

        } finally {
            s.close();
        }
        return tmp;

    }
}
