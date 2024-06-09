

package dao;
import bean.MenuPrice;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/MenuPrice.properties")
@Component()
public class MenuPriceDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(MenuPrice data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public MenuPrice readFromId(long id){
        Session s=this.sf.openSession();
        MenuPrice tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<MenuPrice>get(MenuPrice.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public MenuPrice read(MenuPrice obj){
        Session s=this.sf.openSession();
        MenuPrice tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<MenuPrice>get(MenuPrice.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(MenuPrice data) {
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

