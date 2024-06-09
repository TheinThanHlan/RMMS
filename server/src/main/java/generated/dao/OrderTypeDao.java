

package dao;
import bean.OrderType;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/OrderType.properties")
@Component()
public class OrderTypeDao{
    @Autowired()
    SessionFactory sf;



    public void create(OrderType data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public OrderType readFromId(long id){
        Session s=this.sf.openSession();
        OrderType tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<OrderType>get(OrderType.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public OrderType read(OrderType obj){
        Session s=this.sf.openSession();
        OrderType tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<OrderType>get(OrderType.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(OrderType data) {
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



    public java.util.List<OrderType> readAllOrderTypes() {
        Session s = this.sf.openSession();
        java.util.List<OrderType> tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            jakarta.persistence.Query query = s
                    .createQuery("from OrderType");

            tmp = query.getResultList();
            tx.commit();

        } finally {
            s.close();
        }
        return tmp;

    }
}

