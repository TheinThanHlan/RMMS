

package dao;
import bean.StockSupplier;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/StockSupplier.properties")
@Component()
public class StockSupplierDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(StockSupplier data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public StockSupplier readFromId(long id){
        Session s=this.sf.openSession();
        StockSupplier tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<StockSupplier>get(StockSupplier.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public StockSupplier read(StockSupplier obj){
        Session s=this.sf.openSession();
        StockSupplier tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<StockSupplier>get(StockSupplier.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(StockSupplier data) {
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

