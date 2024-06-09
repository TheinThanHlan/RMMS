

package dao;
import bean.Page;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Page.properties")
@Component()
public class PageDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(Page data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public Page readFromId(long id){
        Session s=this.sf.openSession();
        Page tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Page>get(Page.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public Page read(Page obj){
        Session s=this.sf.openSession();
        Page tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Page>get(Page.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(Page data) {
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

