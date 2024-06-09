package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.StockSupplier;
import bean.Stock;
import bean.StockOrderStatus;
import bean.Employee;

@Entity()
public class StockOrder   implements java.io.Serializable  {
	
	@Id()
	
	@GeneratedValue()
	
	@Expose(serialize = true, deserialize = true)
	private long id;
	
	@CreationTimestamp()
	
	@Expose(serialize = true, deserialize = true)
	private java.sql.Timestamp rowCreatedDateTime;
	
	@ManyToOne()
	
	@Expose(serialize = true, deserialize = true)
	private Stock stock;
	
	@ManyToOne()
	
	@Expose(serialize = true, deserialize = true)
	private Employee orderedEmployee;
	
	@Column(nullable=false)
	
	@Expose(serialize = true, deserialize = true)
	private long orderedQuantity;
	
	@ManyToOne()
	
	@Expose(serialize = true, deserialize = true)
	private Employee recievedEmployee;
	
	@ManyToOne()
	
	@Expose(serialize = true, deserialize = true)
	private StockOrderStatus stockOrderStatus;
	
	@Column(nullable=true)
	
	@Expose(serialize = true, deserialize = true)
	private long recievedQuantity;
	
	@Column(nullable=true)
	
	@Expose(serialize = true, deserialize = true)
	private long price;
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
	public Stock getStock(){
		return this.stock;
		
	}
	public void setStock(Stock stock){
		this.stock=stock;
		
	}
	public Employee getOrderedEmployee(){
		return this.orderedEmployee;
		
	}
	public void setOrderedEmployee(Employee orderedEmployee){
		this.orderedEmployee=orderedEmployee;
		
	}
	public long getOrderedQuantity(){
		return this.orderedQuantity;
		
	}
	public void setOrderedQuantity(long orderedQuantity){
		this.orderedQuantity=orderedQuantity;
		
	}
	public Employee getRecievedEmployee(){
		return this.recievedEmployee;
		
	}
	public void setRecievedEmployee(Employee recievedEmployee){
		this.recievedEmployee=recievedEmployee;
		
	}
	public StockOrderStatus getStockOrderStatus(){
		return this.stockOrderStatus;
		
	}
	public void setStockOrderStatus(StockOrderStatus stockOrderStatus){
		this.stockOrderStatus=stockOrderStatus;
		
	}
	public long getRecievedQuantity(){
		return this.recievedQuantity;
		
	}
	public void setRecievedQuantity(long recievedQuantity){
		this.recievedQuantity=recievedQuantity;
		
	}
	public long getPrice(){
		return this.price;
		
	}
	public void setPrice(long price){
		this.price=price;
		
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
		final StockOrder obj1 = (StockOrder) obj;
		if(this.getId()!=obj1.getId()){
			return false;
			
		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;
			
		}
		if(!this.getStock().equals(obj1.getStock())){
			return false;
			
		}
		if(!this.getOrderedEmployee().equals(obj1.getOrderedEmployee())){
			return false;
			
		}
		if(this.getOrderedQuantity()!=obj1.getOrderedQuantity()){
			return false;
			
		}
		if(!this.getRecievedEmployee().equals(obj1.getRecievedEmployee())){
			return false;
			
		}
		if(!this.getStockOrderStatus().equals(obj1.getStockOrderStatus())){
			return false;
			
		}
		if(this.getRecievedQuantity()!=obj1.getRecievedQuantity()){
			return false;
			
		}
		if(this.getPrice()!=obj1.getPrice()){
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
	public StockOrder clone() throws CloneNotSupportedException {
		StockOrder obj=(StockOrder)super.clone();
		return obj;
		
	}
	
}
