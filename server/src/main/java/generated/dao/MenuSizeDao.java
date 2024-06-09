

package dao;
import bean.MenuSize;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/MenuSize.properties")
@Component()
public class MenuSizeDao{
    @Autowired()
    SessionFactory sf;



    public void create(MenuSize data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public MenuSize readFromId(long id){
        Session s=this.sf.openSession();
        MenuSize tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<MenuSize>get(MenuSize.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public MenuSize read(MenuSize obj){
        Session s=this.sf.openSession();
        MenuSize tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<MenuSize>get(MenuSize.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(MenuSize data) {
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


    public java.util.List<MenuSize> readAll(){
        Session s=this.sf.openSession();
        java.util.List<MenuSize> tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            jakarta.persistence.Query query= s.createQuery("from MenuSize");
            tmp = query.getResultList();
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }


}

