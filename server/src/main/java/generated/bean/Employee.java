package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.StockOrder;
import bean.Task;
import bean.EmployeeSalary;

@Entity()

@Table()
public class Employee   implements java.io.Serializable  {
	
	@Id()
	
	@GeneratedValue()
	
	@Expose(serialize = true, deserialize = true)
	private long id;
	
	@CreationTimestamp()
	
	@Expose(serialize = true, deserialize = true)
	private java.sql.Timestamp rowCreatedDateTime;
	
	@OneToOne()
	
	@Expose(serialize = true, deserialize = true)
	private User user;
	
	@OneToMany(mappedBy="orderedEmployee")
	
	@Expose(serialize = false, deserialize = true)
	private java.util.List<StockOrder> orderedStock;
	
	@OneToMany(mappedBy="recievedEmployee")
	
	@Expose(serialize = false, deserialize = true)
	private java.util.List<StockOrder> recievedStock;
	
	@ManyToMany()
	
	@Expose(serialize = false, deserialize = true)
	private java.util.List<Task> tasks;
	
	@OneToMany(mappedBy="employee")
	
	@Expose(serialize = false, deserialize = true)
	private java.util.List<EmployeeSalary> employeeSalary;
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
	public User getUser(){
		return this.user;
		
	}
	public void setUser(User user){
		this.user=user;
		
	}
	public java.util.List<StockOrder> getOrderedStock(){
		return this.orderedStock;
		
	}
	public void setOrderedStock(java.util.List<StockOrder> orderedStock){
		this.orderedStock=orderedStock;
		
	}
	public java.util.List<StockOrder> getRecievedStock(){
		return this.recievedStock;
		
	}
	public void setRecievedStock(java.util.List<StockOrder> recievedStock){
		this.recievedStock=recievedStock;
		
	}
	public java.util.List<Task> getTasks(){
		return this.tasks;
		
	}
	public void setTasks(java.util.List<Task> tasks){
		this.tasks=tasks;
		
	}
	public java.util.List<EmployeeSalary> getEmployeeSalary(){
		return this.employeeSalary;
		
	}
	public void setEmployeeSalary(java.util.List<EmployeeSalary> employeeSalary){
		this.employeeSalary=employeeSalary;
		
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
		final Employee obj1 = (Employee) obj;
		if(this.getId()!=obj1.getId()){
			return false;
			
		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;
			
		}
		if(!this.getUser().equals(obj1.getUser())){
			return false;
			
		}
		if(!this.getOrderedStock().equals(obj1.getOrderedStock())){
			return false;
			
		}
		if(!this.getRecievedStock().equals(obj1.getRecievedStock())){
			return false;
			
		}
		if(!this.getTasks().equals(obj1.getTasks())){
			return false;
			
		}
		if(!this.getEmployeeSalary().equals(obj1.getEmployeeSalary())){
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
	public Employee clone() throws CloneNotSupportedException {
		Employee obj=(Employee)super.clone();
		return obj;
		
	}
	
}
