package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.Employee;
import bean.Restaurant;
import bean.Authority;

@Entity()
public class EmployeeSalary   implements java.io.Serializable  {
	
	@Id()
	
	@GeneratedValue()
	
	@Expose(serialize = true, deserialize = true)
	private long id;
	
	@CreationTimestamp()
	
	@Expose(serialize = true, deserialize = true)
	private java.sql.Timestamp rowCreatedDateTime;
	
	@ManyToOne()
	
	@Expose(serialize = true, deserialize = true)
	private Employee employee;
	
	@Column(nullable=false)
	
	@Expose(serialize = true, deserialize = true)
	private long salary;
	public long getId(){
		return this.id;
		
	}
	public void setId(long id){
		this.id=id;
		
	}
	public java.sql.Timestamp getRowCreatedDateTime(){
		return this.rowCreatedDateTime;
		
	}
	public void setRowCreatedDateTime(java.sql.Timestamp rowCreatedDateTime){
		this.rowCreatedDateTime=rowCreatedDateTime;
		
	}
	public Employee getEmployee(){
		return this.employee;
		
	}
	public void setEmployee(Employee employee){
		this.employee=employee;
		
	}
	public long getSalary(){
		return this.salary;
		
	}
	public void setSalary(long salary){
		this.salary=salary;
		
	}
	public String toJson(){
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this);
		
	}
	
	@Override()
	public boolean equals(Object obj){
		if (obj == null) {
			return false;
			 
		}
		 if (obj.getClass() != this.getClass()){
			return false;
			
		}
		final EmployeeSalary obj1 = (EmployeeSalary) obj;
		if(this.getId()!=obj1.getId()){
			return false;
			
		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;
			
		}
		if(!this.getEmployee().equals(obj1.getEmployee())){
			return false;
			
		}
		if(this.getSalary()!=obj1.getSalary()){
			return false;
			
		}
		return true;
		
	}
	public String toString(){
		{
			return this.toJson();
			
		}
		
	}
	
	@Override()
	public EmployeeSalary clone() throws CloneNotSupportedException {
		EmployeeSalary obj=(EmployeeSalary)super.clone();
		return obj;
		
	}
	
}
