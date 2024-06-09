package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Account;
import bean.Voucher;
import bean.EmployeeSalary;
import bean.StockOrder;

@Entity()

@Table()
public class AccountTransaction   implements java.io.Serializable  {
	
	@Id()
	
	@GeneratedValue()
	
	@Expose(serialize = true, deserialize = true)
	private long id;
	
	@CreationTimestamp()
	
	@Expose(serialize = true, deserialize = true)
	private java.sql.Timestamp rowCreatedDateTime;
	
	@Column(unique=false,nullable=false)
	
	@Expose(serialize = true, deserialize = true)
	private int direction;
	
	@Column()
	
	@Expose(serialize = true, deserialize = true)
	private String description;
	
	@ManyToOne()
	
	@Expose(serialize = true, deserialize = true)
	private User reciever;
	
	@ManyToOne()
	
	@Expose(serialize = true, deserialize = true)
	private User payer;
	
	@ManyToOne()
	
	@Expose(serialize = true, deserialize = true)
	private Account account;
	
	@OneToOne()
	
	@Expose(serialize = true, deserialize = true)
	private Voucher voucher;
	
	@OneToOne()
	
	@Expose(serialize = true, deserialize = true)
	private EmployeeSalary employeeSalary;
	
	@OneToOne()
	
	@Expose(serialize = true, deserialize = true)
	private StockOrder stockOrder;
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
	public int getDirection(){
		return this.direction;
		
	}
	public void setDirection(int direction){
		this.direction=direction;
		
	}
	public String getDescription(){
		return this.description;
		
	}
	public void setDescription(String description){
		this.description=description;
		
	}
	public User getReciever(){
		return this.reciever;
		
	}
	public void setReciever(User reciever){
		this.reciever=reciever;
		
	}
	public User getPayer(){
		return this.payer;
		
	}
	public void setPayer(User payer){
		this.payer=payer;
		
	}
	public Account getAccount(){
		return this.account;
		
	}
	public void setAccount(Account account){
		this.account=account;
		
	}
	public Voucher getVoucher(){
		return this.voucher;
		
	}
	public void setVoucher(Voucher voucher){
		this.voucher=voucher;
		
	}
	public EmployeeSalary getEmployeeSalary(){
		return this.employeeSalary;
		
	}
	public void setEmployeeSalary(EmployeeSalary employeeSalary){
		this.employeeSalary=employeeSalary;
		
	}
	public StockOrder getStockOrder(){
		return this.stockOrder;
		
	}
	public void setStockOrder(StockOrder stockOrder){
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
		final AccountTransaction obj1 = (AccountTransaction) obj;
		if(this.getId()!=obj1.getId()){
			return false;
			
		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;
			
		}
		if(this.getDirection()!=obj1.getDirection()){
			return false;
			
		}
		if(!this.getDescription().equals(obj1.getDescription())){
			return false;
			
		}
		if(!this.getReciever().equals(obj1.getReciever())){
			return false;
			
		}
		if(!this.getPayer().equals(obj1.getPayer())){
			return false;
			
		}
		if(!this.getAccount().equals(obj1.getAccount())){
			return false;
			
		}
		if(!this.getVoucher().equals(obj1.getVoucher())){
			return false;
			
		}
		if(!this.getEmployeeSalary().equals(obj1.getEmployeeSalary())){
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
	public AccountTransaction clone() throws CloneNotSupportedException {
		AccountTransaction obj=(AccountTransaction)super.clone();
		return obj;
		
	}
	
}
