package bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.Authority;
import bean.MenuTemplate;
import bean.MenuSize;
import bean.MenuPrice;

@Entity()

@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "menuTemplate", "menuSize" }) })

public class Menu implements java.io.Serializable {

    @Id()

    @GeneratedValue()

    @Expose(serialize = true, deserialize = true)
    private long id;

    @CreationTimestamp()

    @Expose(serialize = true, deserialize = true)
    private java.sql.Timestamp rowCreatedDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    @Expose(serialize = true, deserialize = true)
    private MenuTemplate menuTemplate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    @Expose(serialize = true, deserialize = true)
    private MenuSize menuSize;

    @Column(unique = false, nullable = true)
    @Expose(serialize = true, deserialize = true)
    private java.sql.Timestamp cookDuration;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    @Expose(serialize = false, deserialize = true)
    private java.util.List<MenuPrice> menuPrices = new java.util.LinkedList<MenuPrice>();

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

    public MenuTemplate getMenuTemplate() {
        return this.menuTemplate;

    }

    public void setMenuTemplate(MenuTemplate menuTemplate) {
        this.menuTemplate = menuTemplate;

    }

    public MenuSize getMenuSize() {
        return this.menuSize;

    }

    public void setMenuSize(MenuSize menuSize) {
        this.menuSize = menuSize;

    }

    public java.sql.Timestamp getCookDuration() {
        return this.cookDuration;

    }

    public void setCookDuration(java.sql.Timestamp cookDuration) {
        this.cookDuration = cookDuration;

    }

    public java.util.List<MenuPrice> getMenuPrices() {
        return this.menuPrices;

    }

    public void setMenuPrices(java.util.List<MenuPrice> menuPrices) {
        this.menuPrices = menuPrices;

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
        final Menu obj1 = (Menu) obj;
        if (this.getId() != obj1.getId()) {
            return false;

        }
        if (!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())) {
            return false;

        }
        if (!this.getMenuTemplate().equals(obj1.getMenuTemplate())) {
            return false;

        }
        if (!this.getMenuSize().equals(obj1.getMenuSize())) {
            return false;

        }
        if (!this.getCookDuration().equals(obj1.getCookDuration())) {
            return false;

        }
        if (!this.getMenuPrices().equals(obj1.getMenuPrices())) {
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
    public Menu clone() throws CloneNotSupportedException {
        Menu obj = (Menu) super.clone();
        return obj;

    }

}
