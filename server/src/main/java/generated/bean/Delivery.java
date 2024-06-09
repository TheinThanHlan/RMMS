package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.DeliveryMethod;

@Entity()

@Table()
public class Delivery   implements java.io.Serializable  {
	
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
	
	@ManyToMany()
	
	@Expose(serialize = false, deserialize = true)
	private java.util.List<DeliveryMethod> deliveryMethods;
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
	public java.util.List<DeliveryMethod> getDeliveryMethods(){
		return this.deliveryMethods;
		
	}
	public void setDeliveryMethods(java.util.List<DeliveryMethod> deliveryMethods){
		this.deliveryMethods=deliveryMethods;
		
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
		final Delivery obj1 = (Delivery) obj;
		if(this.getId()!=obj1.getId()){
			return false;
			
		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;
			
		}
		if(!this.getUser().equals(obj1.getUser())){
			return false;
			
		}
		if(!this.getDeliveryMethods().equals(obj1.getDeliveryMethods())){
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
	public Delivery clone() throws CloneNotSupportedException {
		Delivery obj=(Delivery)super.clone();
		return obj;
		
	}
	
}
