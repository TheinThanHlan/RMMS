package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.UserGroup;
import bean.Employee;
import bean.Schedule;
import bean.PriorityLevel;

@Entity()

@Table()
public class Task   implements java.io.Serializable  {
	
	@Id()
	
	@GeneratedValue()
	
	@Expose(serialize = true, deserialize = true)
	private long id;
	
	@CreationTimestamp()
	
	@Expose(serialize = true, deserialize = true)
	private java.sql.Timestamp rowCreatedDateTime;
	
	@Expose(serialize = true, deserialize = true)
	private String description;
	
	@Expose(serialize = true, deserialize = true)
	private java.sql.Timestamp dueDateTime;
	
	@OneToOne()
	
	@Expose(serialize = true, deserialize = true)
	private UserGroup employeeGroup;
	
	@ManyToMany(mappedBy="tasks")
	
	@Expose(serialize = false, deserialize = true)
	private java.util.List<Employee> employees;
	
	@ManyToOne()
	
	@Expose(serialize = true, deserialize = true)
	private PriorityLevel priorityLevel;
	
	@ManyToOne()
	
	@Expose(serialize = true, deserialize = true)
	private Schedule schedule;
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
	public String getDescription(){
		return this.description;
		
	}
	public void setDescription(String description){
		this.description=description;
		
	}
	public java.sql.Timestamp getDueDateTime(){
		return this.dueDateTime;
		
	}
	public void setDueDateTime(java.sql.Timestamp dueDateTime){
		this.dueDateTime=dueDateTime;
		
	}
	public UserGroup getEmployeeGroup(){
		return this.employeeGroup;
		
	}
	public void setEmployeeGroup(UserGroup employeeGroup){
		this.employeeGroup=employeeGroup;
		
	}
	public java.util.List<Employee> getEmployees(){
		return this.employees;
		
	}
	public void setEmployees(java.util.List<Employee> employees){
		this.employees=employees;
		
	}
	public PriorityLevel getPriorityLevel(){
		return this.priorityLevel;
		
	}
	public void setPriorityLevel(PriorityLevel priorityLevel){
		this.priorityLevel=priorityLevel;
		
	}
	public Schedule getSchedule(){
		return this.schedule;
		
	}
	public void setSchedule(Schedule schedule){
		this.schedule=schedule;
		
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
		final Task obj1 = (Task) obj;
		if(this.getId()!=obj1.getId()){
			return false;
			
		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;
			
		}
		if(!this.getDescription().equals(obj1.getDescription())){
			return false;
			
		}
		if(!this.getDueDateTime().equals(obj1.getDueDateTime())){
			return false;
			
		}
		if(!this.getEmployeeGroup().equals(obj1.getEmployeeGroup())){
			return false;
			
		}
		if(!this.getEmployees().equals(obj1.getEmployees())){
			return false;
			
		}
		if(!this.getPriorityLevel().equals(obj1.getPriorityLevel())){
			return false;
			
		}
		if(!this.getSchedule().equals(obj1.getSchedule())){
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
	public Task clone() throws CloneNotSupportedException {
		Task obj=(Task)super.clone();
		return obj;
		
	}
	
}
