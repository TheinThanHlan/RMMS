package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.Authority;

@Entity()

@Table()
public class Page   implements java.io.Serializable  {
	
	@Id()
	
	@GeneratedValue()
	
	@Expose(serialize = true, deserialize = true)
	private long id;
	
	@CreationTimestamp()
	
	@Expose(serialize = true, deserialize = true)
	private java.sql.Timestamp rowCreatedDateTime;
	
	@Column(nullable=false)
	
	@Expose(serialize = true, deserialize = true)
	private String name;
	
	@ManyToMany()
	
	@Expose(serialize = false, deserialize = true)
	private java.util.List<Authority> authorities;
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
	public java.util.List<Authority> getAuthorities(){
		return this.authorities;
		
	}
	public void setAuthorities(java.util.List<Authority> authorities){
		this.authorities=authorities;
		
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
		final Page obj1 = (Page) obj;
		if(this.getId()!=obj1.getId()){
			return false;
			
		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;
			
		}
		if(!this.getName().equals(obj1.getName())){
			return false;
			
		}
		if(!this.getAuthorities().equals(obj1.getAuthorities())){
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
	public Page clone() throws CloneNotSupportedException {
		Page obj=(Page)super.clone();
		return obj;
		
	}
	
}
