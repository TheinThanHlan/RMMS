

package dao;
import bean.Account;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Account.properties")
@Component()
public class AccountDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(Account data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public Account readFromId(long id){
        Session s=this.sf.openSession();
        Account tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Account>get(Account.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public Account read(Account obj){
        Session s=this.sf.openSession();
        Account tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Account>get(Account.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(Account data) {
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

