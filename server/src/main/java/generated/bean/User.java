package bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import bean.Marsta;
import bean.Gender;
import bean.Restaurant;
import bean.AccountTransaction;
import bean.UserGroup;

@Entity()

@Table()
public class User implements java.io.Serializable {

    @PrePersist()
    private void genUser() {
        this.setPassword(UUID.randomUUID().toString());
    }

    @Id()

    @GeneratedValue()

    @Expose(serialize = true, deserialize = true)
    private long id;

    @CreationTimestamp()

    @Expose(serialize = true, deserialize = true)
    private java.sql.Timestamp rowCreatedDateTime;

    @Column(nullable = false)
    @Expose(serialize = true, deserialize = true)
    private String name;

    @Column(unique = true)

    @Expose(serialize = true, deserialize = true)
    private String email;

    @Column(unique = true)

    @Expose(serialize = true, deserialize = true)
    private String phone;

    @Column()

    @Expose(serialize = true, deserialize = true)
    private String address;

    @Column(nullable = false)

    @Expose(serialize = true, deserialize = true)
    private String password;

    @Expose(serialize = true, deserialize = true)
    private boolean loginableStatus = false;

    @ManyToOne()

    @Expose(serialize = true, deserialize = true)
    private Marsta marsta;

    @ManyToOne()

    @Expose(serialize = true, deserialize = true)
    private Gender gender;

    @ManyToMany(fetch = FetchType.EAGER)

    @Expose(serialize = true, deserialize = true)
    private java.util.List<Restaurant> restaurant;

    @ManyToOne(fetch = FetchType.EAGER)

    @Expose(serialize = true, deserialize = true)
    private UserGroup userGroup;

    @OneToMany(mappedBy = "reciever")

    @Expose(serialize = false, deserialize = true)
    private java.util.List<AccountTransaction> recievedAccountTransactions;

    @OneToMany(mappedBy = "payer")

    @Expose(serialize = false, deserialize = true)
    private java.util.List<AccountTransaction> paidAccountTransactions;

    public long getId() {
        return this.id;

    }

    public void setId(long id) {
        this.id = id;

    }

    public java.sql.Timestamp getRowCreatedDateTime() {
        return this.rowCreatedDateTime;

    }

    public void setRowCreatedDateTime(java.sql.Timestamp rowCreatedDateTime) {
        this.rowCreatedDateTime = rowCreatedDateTime;

    }

    public String getName() {
        return this.name;

    }

    public void setName(String name) {
        this.name = name;

    }

    public String getEmail() {
        return this.email;

    }

    public void setEmail(String email) {
        this.email = email;

    }

    public String getPhone() {
        return this.phone;

    }

    public void setPhone(String phone) {
        this.phone = phone;

    }

    public String getAddress() {
        return this.address;

    }

    public void setAddress(String address) {
        this.address = address;

    }

    public String getPassword() {
        return this.password;

    }

    public void setPassword(String password) {
        this.password = password;

    }

    public boolean getLoginableStatus() {
        return this.loginableStatus;

    }

    public void setLoginableStatus(boolean loginableStatus) {
        this.loginableStatus = loginableStatus;

    }

    public Marsta getMarsta() {
        return this.marsta;

    }

    public void setMarsta(Marsta marsta) {
        this.marsta = marsta;

    }

    public Gender getGender() {
        return this.gender;

    }

    public void setGender(Gender gender) {
        this.gender = gender;

    }

    public java.util.List<Restaurant> getRestaurant() {
        return this.restaurant;

    }

    public void setRestaurant(java.util.List<Restaurant> restaurant) {
        this.restaurant = restaurant;

    }

    public UserGroup getUserGroup() {
        return this.userGroup;

    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;

    }

    public java.util.List<AccountTransaction> getRecievedAccountTransactions() {
        return this.recievedAccountTransactions;

    }

    public void setRecievedAccountTransactions(java.util.List<AccountTransaction> recievedAccountTransactions) {
        this.recievedAccountTransactions = recievedAccountTransactions;

    }

    public java.util.List<AccountTransaction> getPaidAccountTransactions() {
        return this.paidAccountTransactions;

    }

    public void setPaidAccountTransactions(java.util.List<AccountTransaction> paidAccountTransactions) {
        this.paidAccountTransactions = paidAccountTransactions;

    }

    public String toJson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this);

    }

    @Override()
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;

        }
        if (obj.getClass() != this.getClass()) {
            return false;

        }
        final User obj1 = (User) obj;
        if (this.getId() != obj1.getId()) {
            return false;

        }
        if (!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())) {
            return false;

        }
        if (!this.getName().equals(obj1.getName())) {
            return false;

        }
        if (!this.getEmail().equals(obj1.getEmail())) {
            return false;

        }
        if (!this.getPhone().equals(obj1.getPhone())) {
            return false;

        }
        if (!this.getAddress().equals(obj1.getAddress())) {
            return false;

        }
        if (!this.getPassword().equals(obj1.getPassword())) {
            return false;

        }
        if (this.getLoginableStatus() != obj1.getLoginableStatus()) {
            return false;

        }
        if (!this.getMarsta().equals(obj1.getMarsta())) {
            return false;

        }
        if (!this.getGender().equals(obj1.getGender())) {
            return false;

        }
        if (!this.getRestaurant().equals(obj1.getRestaurant())) {
            return false;

        }
        if (!this.getUserGroup().equals(obj1.getUserGroup())) {
            return false;

        }
        if (!this.getRecievedAccountTransactions().equals(obj1.getRecievedAccountTransactions())) {
            return false;

        }
        if (!this.getPaidAccountTransactions().equals(obj1.getPaidAccountTransactions())) {
            return false;

        }
        return true;

    }

    public String toString() {
        {
            return this.toJson();

        }

    }

    @Override()
    public User clone() throws CloneNotSupportedException {
        User obj = (User) super.clone();
        return obj;

    }

}
