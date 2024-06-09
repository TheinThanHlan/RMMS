package bean;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Authority;
import bean.Table_;
import bean.MenuPrice;

import lombok.Getter;
import lombok.Setter;

@Entity()

@Table()
public class Restaurant   implements java.io.Serializable  {

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

	@Column(unique=true)

	@Expose(serialize = true, deserialize = true)
	private String email;

	@Column(unique=true)

	@Expose(serialize = true, deserialize = true)
	private String phone;

	@Column()

	@Expose(serialize = true, deserialize = true)
	private String address;

	@OneToOne()

	@Expose(serialize = true, deserialize = true)
	private User manager;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="restaurant")

	@Expose(serialize = false, deserialize = true)
	private java.util.List<Table_> table_s;

	@ManyToMany()

	@Expose(serialize = false, deserialize = true)
	private java.util.List<Authority> authorities;

	@OneToMany(mappedBy="restaurant")

	@Expose(serialize = false, deserialize = true)
	private java.util.List<MenuPrice> menuPices;


	@OneToMany(fetch=FetchType.LAZY,mappedBy="restaurant")

	@Expose(serialize = false, deserialize = true)
	@Getter()
    @Setter()
    private java.util.List<Voucher> voucher;



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
	public String getEmail(){
		return this.email;

	}
	public void setEmail(String email){
		this.email=email;

	}
	public String getPhone(){
		return this.phone;

	}
	public void setPhone(String phone){
		this.phone=phone;

	}
	public String getAddress(){
		return this.address;

	}
	public void setAddress(String address){
		this.address=address;

	}
	public User getManager(){
		return this.manager;

	}
	public void setManager(User manager){
		this.manager=manager;

	}
	public java.util.List<Table_> getTable_s(){
		return this.table_s;

	}
	public void setTable_s(java.util.List<Table_> table_s){
		this.table_s=table_s;

	}
	public java.util.List<Authority> getAuthorities(){
		return this.authorities;

	}
	public void setAuthorities(java.util.List<Authority> authorities){
		this.authorities=authorities;

	}
	public java.util.List<MenuPrice> getMenuPices(){
		return this.menuPices;

	}
	public void setMenuPices(java.util.List<MenuPrice> menuPices){
		this.menuPices=menuPices;

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
		final Restaurant obj1 = (Restaurant) obj;
		if(this.getId()!=obj1.getId()){
			return false;

		}
		if(!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())){
			return false;

		}
		if(!this.getName().equals(obj1.getName())){
			return false;

		}
		if(!this.getEmail().equals(obj1.getEmail())){
			return false;

		}
		if(!this.getPhone().equals(obj1.getPhone())){
			return false;

		}
		if(!this.getAddress().equals(obj1.getAddress())){
			return false;

		}
		if(!this.getManager().equals(obj1.getManager())){
			return false;

		}
		if(!this.getTable_s().equals(obj1.getTable_s())){
			return false;

		}
		if(!this.getAuthorities().equals(obj1.getAuthorities())){
			return false;

		}
		if(!this.getMenuPices().equals(obj1.getMenuPices())){
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
	public Restaurant clone() throws CloneNotSupportedException {
		Restaurant obj=(Restaurant)super.clone();
		return obj;

	}

}
