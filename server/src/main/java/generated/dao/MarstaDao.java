

package dao;
import bean.Marsta;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Marsta.properties")
@Component()
public class MarstaDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(Marsta data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public Marsta readFromId(long id){
        Session s=this.sf.openSession();
        Marsta tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Marsta>get(Marsta.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public Marsta read(Marsta obj){
        Session s=this.sf.openSession();
        Marsta tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Marsta>get(Marsta.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(Marsta data) {
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

