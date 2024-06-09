

package dao;
import bean.StockOrder;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/StockOrder.properties")
@Component()
public class StockOrderDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(StockOrder data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public StockOrder readFromId(long id){
        Session s=this.sf.openSession();
        StockOrder tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<StockOrder>get(StockOrder.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public StockOrder read(StockOrder obj){
        Session s=this.sf.openSession();
        StockOrder tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<StockOrder>get(StockOrder.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(StockOrder data) {
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

