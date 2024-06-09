

package dao;
import bean.DeliveryMethod;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/DeliveryMethod.properties")
@Component()
public class DeliveryMethodDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(DeliveryMethod data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public DeliveryMethod readFromId(long id){
        Session s=this.sf.openSession();
        DeliveryMethod tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<DeliveryMethod>get(DeliveryMethod.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public DeliveryMethod read(DeliveryMethod obj){
        Session s=this.sf.openSession();
        DeliveryMethod tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<DeliveryMethod>get(DeliveryMethod.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(DeliveryMethod data) {
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

