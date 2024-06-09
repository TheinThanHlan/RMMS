

package dao;
import bean.OrderStatus;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/OrderStatus.properties")
@Component()
public class OrderStatusDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(OrderStatus data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public OrderStatus readFromId(long id){
        Session s=this.sf.openSession();
        OrderStatus tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<OrderStatus>get(OrderStatus.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public OrderStatus read(OrderStatus obj){
        Session s=this.sf.openSession();
        OrderStatus tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<OrderStatus>get(OrderStatus.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(OrderStatus data) {
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

