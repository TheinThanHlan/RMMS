package bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.State;
import bean.Authority;
import bean.Menu;
import bean.OrderType;
import bean.OrderStatus;
import bean.Voucher;

@Entity()

@Table()
public class MenuOrder implements java.io.Serializable {

    @Id()

    @GeneratedValue()

    @Expose(serialize = true, deserialize = true)
    private long id;

    @CreationTimestamp()

    @Expose(serialize = true, deserialize = true)
    private java.sql.Timestamp rowCreatedDateTime;

    @ManyToOne(fetch = FetchType.EAGER)

    @Expose(serialize = true, deserialize = true)
    private Menu menu;

    @ManyToOne()
    @Expose(serialize = true, deserialize = true)
    private OrderType orderType;

    @ManyToOne()

    @Expose(serialize = true, deserialize = true)
    private State orderState;

    @Column(unique = false, nullable = true)

    @Expose(serialize = true, deserialize = true)
    private java.sql.Timestamp cookStartTime;

    @Column(unique = false, nullable = true)

    @Expose(serialize = true, deserialize = true)
    private java.sql.Timestamp cookEndTime;

    @Column(unique = false, nullable = true)

    @Expose(serialize = true, deserialize = true)
    private java.sql.Timestamp dueDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @Expose(serialize = false, deserialize = true)
    private Voucher voucher;

    /*
     * @Getter()
     *
     * @Setter()
     *
     * @Column(unique = false, nullable = false)
     *
     * @Expose(serialize = true, deserialize = true)
     * private int numbersOfOrder;
     */
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

    public Menu getMenu() {
        return this.menu;

    }

    public void setMenu(Menu menu) {
        this.menu = menu;

    }

    public OrderType getOrderType() {
        return this.orderType;

    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;

    }

    public java.sql.Timestamp getCookStartTime() {
        return this.cookStartTime;

    }

    public void setCookStartTime(java.sql.Timestamp cookStartTime) {
        this.cookStartTime = cookStartTime;

    }

    public java.sql.Timestamp getCookEndTime() {
        return this.cookEndTime;

    }

    public void setCookEndTime(java.sql.Timestamp cookEndTime) {
        this.cookEndTime = cookEndTime;

    }

    public java.sql.Timestamp getDueDateTime() {
        return this.dueDateTime;

    }

    public void setDueDateTime(java.sql.Timestamp dueDateTime) {
        this.dueDateTime = dueDateTime;

    }

    public Voucher getVoucher() {
        return this.voucher;

    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;

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
        final MenuOrder obj1 = (MenuOrder) obj;
        if (this.getId() != obj1.getId()) {
            return false;

        }
        if (!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())) {
            return false;

        }
        if (!this.getMenu().equals(obj1.getMenu())) {
            return false;

        }
        if (!this.getOrderType().equals(obj1.getOrderType())) {
            return false;

        }
        if (!this.getCookStartTime().equals(obj1.getCookStartTime())) {
            return false;

        }
        if (!this.getCookEndTime().equals(obj1.getCookEndTime())) {
            return false;

        }
        if (!this.getDueDateTime().equals(obj1.getDueDateTime())) {
            return false;

        }
        if (!this.getVoucher().equals(obj1.getVoucher())) {
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
    public MenuOrder clone() throws CloneNotSupportedException {
        MenuOrder obj = (MenuOrder) super.clone();
        return obj;

    }

}
