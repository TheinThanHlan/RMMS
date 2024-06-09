package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.AccountTransaction;

@Entity()

@Table()
public class Account   implements java.io.Serializable  {
	
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
	private int number;
	
	@Column(nullable=false)
	
	@Expose(serialize = true, deserialize = true)
	private int normal;
	
	@OneToMany(mappedBy="account")
	
	@Expose(serialize = false, deserialize = true)
	private java.util.LinkedList<AccountTransaction> transactions;
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
	public int getNumber(){
		return this.number;
		
	}
	public void setNumber(int number){
		this.number=number;
		
	}
	public int getNormal(){
		return this.normal;
		
	}
	public void setNormal(int normal){
		this.normal=normal;
		
	}
	public java.util.LinkedList<AccountTransaction> getTransactions(){
		return this.transactions;
		
	}
	public void setTransactions(java.util.LinkedList<AccountTransaction> transactions){
		this.transactions=transactions;
		
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
		final Account obj1 = (Account) obj;
		if(this.getId()!=obj1.getId()){
			return false;
			
		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;
			
		}
		if(!this.getName().equals(obj1.getName())){
			return false;
			
		}
		if(this.getNumber()!=obj1.getNumber()){
			return false;
			
		}
		if(this.getNormal()!=obj1.getNormal()){
			return false;
			
		}
		if(!this.getTransactions().equals(obj1.getTransactions())){
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
	public Account clone() throws CloneNotSupportedException {
		Account obj=(Account)super.clone();
		return obj;
		
	}
	
}
