

package dao;
import bean.AccountTransaction;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/AccountTransaction.properties")
@Component()
public class AccountTransactionDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(AccountTransaction data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public AccountTransaction readFromId(long id){
        Session s=this.sf.openSession();
        AccountTransaction tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<AccountTransaction>get(AccountTransaction.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public AccountTransaction read(AccountTransaction obj){
        Session s=this.sf.openSession();
        AccountTransaction tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<AccountTransaction>get(AccountTransaction.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(AccountTransaction data) {
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

