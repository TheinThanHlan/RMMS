

package dao;
import bean.Authority;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Authority.properties")
@Component()
public class AuthorityDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(Authority data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public Authority readFromId(long id){
        Session s=this.sf.openSession();
        Authority tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Authority>get(Authority.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public Authority read(Authority obj){
        Session s=this.sf.openSession();
        Authority tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Authority>get(Authority.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(Authority data) {
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

