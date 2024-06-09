package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.Page;

@Entity()

@Table()
public class Authority   implements java.io.Serializable  {
	
	@Id()
	
	@GeneratedValue()
	
	@Expose(serialize = true, deserialize = true)
	private long id;
	
	@CreationTimestamp()
	
	@Expose(serialize = true, deserialize = true)
	private java.sql.Timestamp rowCreatedDateTime;
	
	@ManyToMany(mappedBy="authorities")
	
	@Expose(serialize = false, deserialize = true)
	private java.util.List<Restaurant> restaurants;
	
	@ManyToMany(mappedBy="authorities")
	
	@Expose(serialize = false, deserialize = true)
	private java.util.List<Page> pages;
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
	public java.util.List<Restaurant> getRestaurants(){
		return this.restaurants;
		
	}
	public void setRestaurants(java.util.List<Restaurant> restaurants){
		this.restaurants=restaurants;
		
	}
	public java.util.List<Page> getPages(){
		return this.pages;
		
	}
	public void setPages(java.util.List<Page> pages){
		this.pages=pages;
		
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
		final Authority obj1 = (Authority) obj;
		if(this.getId()!=obj1.getId()){
			return false;
			
		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;
			
		}
		if(!this.getRestaurants().equals(obj1.getRestaurants())){
			return false;
			
		}
		if(!this.getPages().equals(obj1.getPages())){
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
	public Authority clone() throws CloneNotSupportedException {
		Authority obj=(Authority)super.clone();
		return obj;
		
	}
	
}
