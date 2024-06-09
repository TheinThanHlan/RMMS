

package dao;
import bean.MenuTemplate;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/MenuTemplate.properties")
@Component()
public class MenuTemplateDao{
    @Autowired()
    SessionFactory sf;



    public void create(MenuTemplate data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public MenuTemplate readFromId(long id){
        Session s=this.sf.openSession();
        MenuTemplate tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<MenuTemplate>get(MenuTemplate.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public MenuTemplate read(MenuTemplate obj){
        Session s=this.sf.openSession();
        MenuTemplate tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<MenuTemplate>get(MenuTemplate.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(MenuTemplate data) {
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


    public java.util.List<MenuTemplate> readAll(){
        Session s=this.sf.openSession();
        java.util.List<MenuTemplate> tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            jakarta.persistence.Query query= s.createQuery("from MenuTemplate");
            tmp = query.getResultList();
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }


}

