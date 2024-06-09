
package dao;

import bean.UserGroup;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/UserGroup.properties")
@Component()
public class UserGroupDao {
    @Autowired()
    SessionFactory sf;

    public void create(UserGroup data) {
        Session s = this.sf.openSession();
        try {
            Transaction tx = s.beginTransaction();
            s.save(data);
            tx.commit();

        } finally {
            s.close();
        }
    }

    public UserGroup readFromId(long id) {
        Session s = this.sf.openSession();
        UserGroup tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<UserGroup>get(UserGroup.class, id);
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public UserGroup read(UserGroup obj) {
        Session s = this.sf.openSession();
        UserGroup tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<UserGroup>get(UserGroup.class, obj.getId());
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public void update(UserGroup data) {
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

    public java.util.List<UserGroup> readAllUserGroupsOfType(long id) {
        Session s = this.sf.openSession();
        java.util.List<UserGroup> tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            jakarta.persistence.Query query = s.createQuery("FROM UserGroup ug where ug.type.id =" + id);

            tmp = query.getResultList();

            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

}
