

package dao;
import bean.PriorityLevel;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/PriorityLevel.properties")
@Component()
public class PriorityLevelDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(PriorityLevel data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public PriorityLevel readFromId(long id){
        Session s=this.sf.openSession();
        PriorityLevel tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<PriorityLevel>get(PriorityLevel.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public PriorityLevel read(PriorityLevel obj){
        Session s=this.sf.openSession();
        PriorityLevel tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<PriorityLevel>get(PriorityLevel.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(PriorityLevel data) {
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

