package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.UserGroup;
import bean.Task;

@Entity()

@Table()
public class Schedule   implements java.io.Serializable  {
	
	@Id()
	
	@GeneratedValue()
	
	@Expose(serialize = true, deserialize = true)
	private long id;
	
	@CreationTimestamp()
	
	@Expose(serialize = true, deserialize = true)
	private java.sql.Timestamp rowCreatedDateTime;
	
	@Column(unique=true,nullable=false)
	
	@Expose(serialize = true, deserialize = true)
	private String name;
	
	@Column(unique=true,nullable=false)
	
	@Expose(serialize = true, deserialize = true)
	private String cronJobCode;
	
	@OneToMany(mappedBy="schedule")
	
	@Expose(serialize = false, deserialize = true)
	private java.util.List<Task> tasks;
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
	public String getName(){
		return this.name;
		
	}
	public void setName(String name){
		this.name=name;
		
	}
	public String getCronJobCode(){
		return this.cronJobCode;
		
	}
	public void setCronJobCode(String cronJobCode){
		this.cronJobCode=cronJobCode;
		
	}
	public java.util.List<Task> getTasks(){
		return this.tasks;
		
	}
	public void setTasks(java.util.List<Task> tasks){
		this.tasks=tasks;
		
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
		final Schedule obj1 = (Schedule) obj;
		if(this.getId()!=obj1.getId()){
			return false;
			
		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;
			
		}
		if(!this.getName().equals(obj1.getName())){
			return false;
			
		}
		if(!this.getCronJobCode().equals(obj1.getCronJobCode())){
			return false;
			
		}
		if(!this.getTasks().equals(obj1.getTasks())){
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
	public Schedule clone() throws CloneNotSupportedException {
		Schedule obj=(Schedule)super.clone();
		return obj;
		
	}
	
}
