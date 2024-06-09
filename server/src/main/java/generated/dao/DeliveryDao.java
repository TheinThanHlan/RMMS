

package dao;
import bean.Delivery;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Delivery.properties")
@Component()
public class DeliveryDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(Delivery data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public Delivery readFromId(long id){
        Session s=this.sf.openSession();
        Delivery tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Delivery>get(Delivery.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public Delivery read(Delivery obj){
        Session s=this.sf.openSession();
        Delivery tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Delivery>get(Delivery.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(Delivery data) {
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

