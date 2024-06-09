package bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.Authority;
import bean.Menu;

@Entity()

@Table()
public class MenuPrice implements java.io.Serializable {

    @Id()

    @GeneratedValue()

    @Expose(serialize = true, deserialize = true)
    private long id;

    @CreationTimestamp()

    @Expose(serialize = true, deserialize = true)
    private java.sql.Timestamp rowCreatedDateTime;

    @Column(nullable = false)

    @Expose(serialize = true, deserialize = true)
    private long price;

    @ManyToOne(fetch = FetchType.LAZY)

    @Expose(serialize = false, deserialize = true)
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @Expose(serialize = false, deserialize = true)
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

    public long getPrice() {
        return this.price;

    }

    public void setPrice(long price) {
        this.price = price;

    }

    public Menu getMenu() {
        return this.menu;

    }

    public void setMenu(Menu menu) {
        this.menu = menu;

    }

    public Restaurant getRestaurant() {
        return this.restaurant;

    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;

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
        final MenuPrice obj1 = (MenuPrice) obj;
        if (this.getId() != obj1.getId()) {
            return false;

        }
        if (!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())) {
            return false;

        }
        if (this.getPrice() != obj1.getPrice()) {
            return false;

        }
        if (!this.getMenu().equals(obj1.getMenu())) {
            return false;

        }
        if (!this.getRestaurant().equals(obj1.getRestaurant())) {
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
    public MenuPrice clone() throws CloneNotSupportedException {
        MenuPrice obj = (MenuPrice) super.clone();
        return obj;

    }

}
