

package dao;
import bean.Schedule;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Schedule.properties")
@Component()
public class ScheduleDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(Schedule data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public Schedule readFromId(long id){
        Session s=this.sf.openSession();
        Schedule tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Schedule>get(Schedule.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public Schedule read(Schedule obj){
        Session s=this.sf.openSession();
        Schedule tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Schedule>get(Schedule.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(Schedule data) {
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

