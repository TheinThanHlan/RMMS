package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.Voucher;
import bean.State;

@Entity()

@Table()
public class Table_   implements java.io.Serializable  {

	@Id()

	@GeneratedValue()

	@Expose(serialize = true, deserialize = true)
	private long id;

	@CreationTimestamp()

	@Expose(serialize = true, deserialize = true)
	private java.sql.Timestamp rowCreatedDateTime;

	@Column(nullable=false,unique=true)

	@Expose(serialize = true, deserialize = true)
	private String name;

	@ManyToOne(fetch=FetchType.LAZY)

	@Expose(serialize = false, deserialize = true)
	private Restaurant restaurant;

	@Expose(serialize = true, deserialize = true)
	private int maxServeCustomer;

	@OneToMany(mappedBy="table_")

	@Expose(serialize = false, deserialize = true)
	private java.util.List<Voucher> vouchers;

	@ManyToOne(fetch=FetchType.EAGER)

	@Expose(serialize = true, deserialize = true)
	private State state;
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
	public Restaurant getRestaurant(){
		return this.restaurant;

	}
	public void setRestaurant(Restaurant restaurant){
		this.restaurant=restaurant;

	}
	public int getMaxServeCustomer(){
		return this.maxServeCustomer;

	}
	public void setMaxServeCustomer(int maxServeCustomer){
		this.maxServeCustomer=maxServeCustomer;

	}
	public java.util.List<Voucher> getVouchers(){
		return this.vouchers;

	}
	public void setVouchers(java.util.List<Voucher> vouchers){
		this.vouchers=vouchers;

	}
	public State getState(){
		return this.state;

	}
	public void setState(State state){
		this.state=state;

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
		final Table_ obj1 = (Table_) obj;
		if(this.getId()!=obj1.getId()){
			return false;

		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;

		}
		if(!this.getName().equals(obj1.getName())){
			return false;

		}
		if(!this.getRestaurant().equals(obj1.getRestaurant())){
			return false;

		}
		if(this.getMaxServeCustomer()!=obj1.getMaxServeCustomer()){
			return false;

		}
		if(!this.getVouchers().equals(obj1.getVouchers())){
			return false;

		}
		if(!this.getState().equals(obj1.getState())){
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
	public Table_ clone() throws CloneNotSupportedException {
		Table_ obj=(Table_)super.clone();
		return obj;

	}

}
