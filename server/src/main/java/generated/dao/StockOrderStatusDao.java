

package dao;
import bean.StockOrderStatus;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/StockOrderStatus.properties")
@Component()
public class StockOrderStatusDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(StockOrderStatus data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public StockOrderStatus readFromId(long id){
        Session s=this.sf.openSession();
        StockOrderStatus tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<StockOrderStatus>get(StockOrderStatus.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public StockOrderStatus read(StockOrderStatus obj){
        Session s=this.sf.openSession();
        StockOrderStatus tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<StockOrderStatus>get(StockOrderStatus.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(StockOrderStatus data) {
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

