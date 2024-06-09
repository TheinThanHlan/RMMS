

package dao;
import bean.Task;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Task.properties")
@Component()
public class TaskDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(Task data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public Task readFromId(long id){
        Session s=this.sf.openSession();
        Task tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Task>get(Task.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public Task read(Task obj){
        Session s=this.sf.openSession();
        Task tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Task>get(Task.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(Task data) {
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

