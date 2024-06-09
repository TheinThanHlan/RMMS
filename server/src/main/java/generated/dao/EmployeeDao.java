
package dao;

import bean.Employee;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Employee.properties")
@Component()
public class EmployeeDao {
    @Autowired()
    SessionFactory sf;

    public void create(Employee data) {
        Session s = this.sf.openSession();
        try {
            Transaction tx = s.beginTransaction();
            s.save(data);
            tx.commit();

        } finally {
            s.close();
        }
    }

    public Employee readFromId(long id) {
        Session s = this.sf.openSession();
        Employee tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<Employee>get(Employee.class, id);
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public Employee read(Employee obj) {
        Session s = this.sf.openSession();
        Employee tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<Employee>get(Employee.class, obj.getId());
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public void update(Employee data) {
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

    public java.util.List<Employee> readAllEmployees(long restaurantId) {
        Session s = this.sf.openSession();
        java.util.List<Employee> tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            jakarta.persistence.Query query = s
                    .createQuery(
                            "select e from Employee e inner join e.user.restaurant r where r.id=" + restaurantId);

            tmp = query.getResultList();

            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

}
