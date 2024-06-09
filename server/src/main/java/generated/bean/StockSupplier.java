package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.Stock;

@Entity()
public class StockSupplier   implements java.io.Serializable  {
	
	@Id()
	
	@GeneratedValue()
	
	@Expose(serialize = true, deserialize = true)
	private long id;
	
	@CreationTimestamp()
	
	@Expose(serialize = true, deserialize = true)
	private java.sql.Timestamp rowCreatedDateTime;
	
	@OneToOne(fetch=FetchType.EAGER)
	
	@Expose(serialize = true, deserialize = true)
	private User user;
	
	@ManyToMany(fetch=FetchType.LAZY)
	
	@Expose(serialize = false, deserialize = true)
	private java.util.List<Stock> stock;
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
	public java.util.List<Stock> getStock(){
		return this.stock;
		
	}
	public void setStock(java.util.List<Stock> stock){
		this.stock=stock;
		
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
		final StockSupplier obj1 = (StockSupplier) obj;
		if(this.getId()!=obj1.getId()){
			return false;
			
		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;
			
		}
		if(!this.getUser().equals(obj1.getUser())){
			return false;
			
		}
		if(!this.getStock().equals(obj1.getStock())){
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
	public StockSupplier clone() throws CloneNotSupportedException {
		StockSupplier obj=(StockSupplier)super.clone();
		return obj;
		
	}
	
}
