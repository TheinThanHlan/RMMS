
package dao;

import bean.Type;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Type.properties")
@Component()
public class TypeDao {
    @Autowired()
    SessionFactory sf;

    public void create(Type data) {
        Session s = this.sf.openSession();
        try {
            Transaction tx = s.beginTransaction();
            s.save(data);
            tx.commit();

        } finally {
            s.close();
        }
    }

    public Type readFromId(long id) {
        Session s = this.sf.openSession();
        Type tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<Type>get(Type.class, id);
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public Type read(Type obj) {
        Session s = this.sf.openSession();
        Type tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<Type>get(Type.class, obj.getId());
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public void update(Type data) {
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

    public java.util.List<Type> readAllTypes() {
        Session s = this.sf.openSession();
        java.util.List<Type> tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            jakarta.persistence.Query query = s.createQuery("FROM Type ");

            tmp = query.getResultList();

            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

}
