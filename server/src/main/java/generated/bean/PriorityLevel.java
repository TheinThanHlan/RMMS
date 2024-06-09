package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.UserGroup;
import bean.Task;

@Entity()

@Table()
public class PriorityLevel   implements java.io.Serializable  {
	
	@Id()
	
	@GeneratedValue()
	
	@Expose(serialize = true, deserialize = true)
	private long id;
	
	@CreationTimestamp()
	
	@Expose(serialize = true, deserialize = true)
	private java.sql.Timestamp rowCreatedDateTime;
	
	@Expose(serialize = true, deserialize = true)
	private String name;
	
	@Column(unique=true,nullable=false)
	
	@Expose(serialize = true, deserialize = true)
	private int levelInDecimal;
	
	@OneToMany(mappedBy="priorityLevel")
	
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
	public int getLevelInDecimal(){
		return this.levelInDecimal;
		
	}
	public void setLevelInDecimal(int levelInDecimal){
		this.levelInDecimal=levelInDecimal;
		
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
		final PriorityLevel obj1 = (PriorityLevel) obj;
		if(this.getId()!=obj1.getId()){
			return false;
			
		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;
			
		}
		if(!this.getName().equals(obj1.getName())){
			return false;
			
		}
		if(this.getLevelInDecimal()!=obj1.getLevelInDecimal()){
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
	public PriorityLevel clone() throws CloneNotSupportedException {
		PriorityLevel obj=(PriorityLevel)super.clone();
		return obj;
		
	}
	
}
