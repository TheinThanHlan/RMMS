package bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.Table_;
import bean.Authority;
import bean.Menu;
import bean.MenuOrder;
import lombok.Getter;
import lombok.Setter;

@Entity()

@Table()
public class Voucher implements java.io.Serializable {

    @Id()

    @GeneratedValue()

    @Expose(serialize = true, deserialize = true)
    private long id;

    @CreationTimestamp()

    @Expose(serialize = true, deserialize = true)
    private java.sql.Timestamp rowCreatedDateTime;

    @ManyToOne()

    @Expose(serialize = true, deserialize = true)
    private Table_ table_;

    @OneToMany(mappedBy = "voucher", fetch = FetchType.LAZY)
    @Expose(serialize = false, deserialize = true)
    private java.util.List<MenuOrder> menuOrders;

    @ManyToOne()
    @Expose(serialize = true, deserialize = true)
    @Getter()
    @Setter()
    private State state;

    @ManyToOne(fetch = FetchType.LAZY)
    @Expose(serialize = false, deserialize = true)
    @Getter()
    @Setter()
    private Restaurant restaurant;

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

    public Table_ getTable_() {
        return this.table_;

    }

    public void setTable_(Table_ table_) {
        this.table_ = table_;

    }

    public java.util.List<MenuOrder> getMenuOrders() {
        return this.menuOrders;

    }

    public void setMenuOrders(java.util.List<MenuOrder> orders) {
        this.menuOrders = menuOrders;

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
        final Voucher obj1 = (Voucher) obj;
        if (this.getId() != obj1.getId()) {
            return false;

        }
        if (!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())) {
            return false;

        }
        if (!this.getTable_().equals(obj1.getTable_())) {
            return false;

        }
        if (!this.getMenuOrders().equals(obj1.getMenuOrders())) {
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
    public Voucher clone() throws CloneNotSupportedException {
        Voucher obj = (Voucher) super.clone();
        return obj;

    }

}
