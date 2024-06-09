

package dao;
import bean.Table_;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Table_.properties")
@Component()
public class Table_Dao{
    @Autowired()
    SessionFactory sf;



    public void create(Table_ data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public Table_ readFromId(long id){
        Session s=this.sf.openSession();
        Table_ tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Table_>get(Table_.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public Table_ read(Table_ obj){
        Session s=this.sf.openSession();
        Table_ tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<Table_>get(Table_.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(Table_ data) {
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


    public java.util.List<Table_> readAll(long restaurantId){
        Session s=this.sf.openSession();
        java.util.List<Table_> tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            jakarta.persistence.Query query= s.createQuery("FROM Table_ m where m.restaurant.id ="+restaurantId);

            tmp = query.getResultList();

            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

}

