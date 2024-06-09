

package dao;
import bean.Restaurant;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Restaurant.properties")
@Component()
public class RestaurantDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(Restaurant data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public Restaurant readFromId(long id){
        Session s=this.sf.openSession();
        Restaurant tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Restaurant>get(Restaurant.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public Restaurant read(Restaurant obj){
        Session s=this.sf.openSession();
        Restaurant tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Restaurant>get(Restaurant.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(Restaurant data) {
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

