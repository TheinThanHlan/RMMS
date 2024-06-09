package bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.Authority;
import bean.Menu;
import bean.MenuOrder;

@Entity()

@Table()
public class OrderStatus implements java.io.Serializable {

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

    @Column(nullable = false)

    @Expose(serialize = true, deserialize = true)
    private String guiColor;

    /*
     * @OneToMany(mappedBy="orderStatus")
     *
     * @Expose(serialize = false, deserialize = true)
     * private java.util.List<Order> orders;
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

    public String getName() {
        return this.name;

    }

    public void setName(String name) {
        this.name = name;

    }

    public String getGuiColor() {
        return this.guiColor;

    }

    public void setGuiColor(String guiColor) {
        this.guiColor = guiColor;

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
        final OrderStatus obj1 = (OrderStatus) obj;
        if (this.getId() != obj1.getId()) {
            return false;

        }
        if (!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())) {
            return false;

        }
        if (!this.getName().equals(obj1.getName())) {
            return false;

        }
        if (!this.getGuiColor().equals(obj1.getGuiColor())) {
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
    public OrderStatus clone() throws CloneNotSupportedException {
        OrderStatus obj = (OrderStatus) super.clone();
        return obj;

    }

}
