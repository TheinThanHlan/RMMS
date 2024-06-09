
package dao;

import bean.User;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/User.properties")
@Component()
public class UserDao {
    @Autowired()
    SessionFactory sf;

    public void create(User data) {
        Session s = this.sf.openSession();
        try {
            Transaction tx = s.beginTransaction();
            s.save(data);
            tx.commit();

        } finally {
            s.close();
        }
    }

    public User readFromId(long id) {
        Session s = this.sf.openSession();
        User tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<User>get(User.class, id);
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public User read(User obj) {
        Session s = this.sf.openSession();
        User tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<User>get(User.class, obj.getId());
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public void update(User data) {
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

    public User readUserFromUserNameAndPassword(User obj) {
        Session s = this.sf.openSession();
        User tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            jakarta.persistence.Query query = s.createQuery(
                    "from User U where U.loginableStatus= true and  U.password= :password");
            query.setParameter("password", obj.getPassword());
            tmp = (User) query.getSingleResult();
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }
}
