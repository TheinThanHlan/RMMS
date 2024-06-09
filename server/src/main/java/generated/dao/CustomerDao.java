

package dao;
import bean.Customer;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Customer.properties")
@Component()
public class CustomerDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(Customer data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public Customer readFromId(long id){
        Session s=this.sf.openSession();
        Customer tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Customer>get(Customer.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public Customer read(Customer obj){
        Session s=this.sf.openSession();
        Customer tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Customer>get(Customer.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(Customer data) {
	    Session s=this.sf.openSession();
        try{
            Transaction t=s.beginTransaction();
            s.persist(data);
            t.commit();

        }finally{
            s.close();
        }
    }

	public void delete(long id) {
	    Session s=this.sf.openSession();
        try{
            Transaction t=s.beginTransaction();
            s.remove(this.readFromId(id));
            t.commit();


        }finally{
            s.close();
        }
    }



}

