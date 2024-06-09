

package dao;
import bean.Gender;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Gender.properties")
@Component()
public class GenderDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(Gender data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public Gender readFromId(long id){
        Session s=this.sf.openSession();
        Gender tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Gender>get(Gender.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public Gender read(Gender obj){
        Session s=this.sf.openSession();
        Gender tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Gender>get(Gender.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(Gender data) {
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

