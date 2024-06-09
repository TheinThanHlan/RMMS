

package dao;
import bean.EmployeeSalary;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/EmployeeSalary.properties")
@Component()
public class EmployeeSalaryDao{
    @Autowired()
    SessionFactory sf;


    
    public void create(EmployeeSalary data){
        Session s=this.sf.openSession();
        try{
            Transaction tx=s.beginTransaction();
            s.save(data);
            tx.commit();

        }finally{
            s.close();
        }
    }

    public EmployeeSalary readFromId(long id){
        Session s=this.sf.openSession();
        EmployeeSalary tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<EmployeeSalary>get(EmployeeSalary.class,id);
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

 public EmployeeSalary read(EmployeeSalary obj){
        Session s=this.sf.openSession();
        EmployeeSalary tmp=null;
        try{
            Transaction tx=s.beginTransaction();
            tmp=s.<EmployeeSalary>get(EmployeeSalary.class,obj.getId());
            tx.commit();
        }finally{
            s.close();
        }
        return tmp;

    }

    public void update(EmployeeSalary data) {
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

