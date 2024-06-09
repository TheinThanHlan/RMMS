

package dao;
import bean.Stock;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Stock.properties")
@Component()
public class StockDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(Stock data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public Stock readFromId(long id){
        Session s=this.sf.openSession();
        Stock tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Stock>get(Stock.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public Stock read(Stock obj){
        Session s=this.sf.openSession();
        Stock tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Stock>get(Stock.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(Stock data) {
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

