
package dao;

import bean.State;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/State.properties")
@Component()
public class StateDao {
    @Autowired()
    SessionFactory sf;

    public void create(State data) {
        Session s = this.sf.openSession();
        try {
            Transaction tx = s.beginTransaction();
            s.save(data);
            tx.commit();

        } finally {
            s.close();
        }
    }

    public State readFromId(long id) {
        Session s = this.sf.openSession();
        State tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<State>get(State.class, id);
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public State read(State obj) {
        Session s = this.sf.openSession();
        State tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<State>get(State.class, obj.getId());
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public void update(State data) {
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

    public java.util.List<State> readAllStatesOfType(long typeId) {
        Session s = this.sf.openSession();
        java.util.List<State> tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            jakarta.persistence.Query query = s.createQuery("from State s where s.type.id=" + typeId);
            tmp = query.getResultList();
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

}
