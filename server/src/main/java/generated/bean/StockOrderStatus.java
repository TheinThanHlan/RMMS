package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.StockSupplier;
import bean.Stock;
import bean.StockOrder;
import bean.Employee;

@Entity()
public class StockOrderStatus   implements java.io.Serializable  {
	
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
	
	@Column(nullable=false)
	
	@Expose(serialize = true, deserialize = true)
	private String guiColor;
	
	@OneToMany(mappedBy="stockOrderStatus")
	
	@Expose(serialize = false, deserialize = true)
	private java.util.List<StockOrder> stockOrder;
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
	public String getGuiColor(){
		return this.guiColor;
		
	}
	public void setGuiColor(String guiColor){
		this.guiColor=guiColor;
		
	}
	public java.util.List<StockOrder> getStockOrder(){
		return this.stockOrder;
		
	}
	public void setStockOrder(java.util.List<StockOrder> stockOrder){
		this.stockOrder=stockOrder;
		
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
		final StockOrderStatus obj1 = (StockOrderStatus) obj;
		if(this.getId()!=obj1.getId()){
			return false;
			
		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;
			
		}
		if(!this.getName().equals(obj1.getName())){
			return false;
			
		}
		if(!this.getGuiColor().equals(obj1.getGuiColor())){
			return false;
			
		}
		if(!this.getStockOrder().equals(obj1.getStockOrder())){
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
	public StockOrderStatus clone() throws CloneNotSupportedException {
		StockOrderStatus obj=(StockOrderStatus)super.clone();
		return obj;
		
	}
	
}
