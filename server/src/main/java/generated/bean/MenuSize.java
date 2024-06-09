package bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.User;
import bean.Restaurant;
import bean.Authority;
import bean.Menu;
import lombok.*;

@Entity()

@Table()
public class MenuSize implements java.io.Serializable {

    @Id()

    @GeneratedValue()

    @Expose(serialize = true, deserialize = true)
    private long id;

    @CreationTimestamp()

    @Expose(serialize = true, deserialize = true)
    private java.sql.Timestamp rowCreatedDateTime;

    @Column(nullable = false, unique = false)

    @Expose(serialize = true, deserialize = true)
    private String name;

    @OneToMany(mappedBy = "menuSize")
    @Expose(serialize = false, deserialize = true)
    private java.util.List<Menu> menus;

    @Getter()
    @Setter()
    @ManyToOne()
    @Expose(serialize = true, deserialize = true)
    @JoinColumn(nullable = false)
    private Category category;

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

    public java.util.List<Menu> getMenus() {
        return this.menus;

    }

    public void setMenus(java.util.List<Menu> menus) {
        this.menus = menus;

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
        final MenuSize obj1 = (MenuSize) obj;
        if (this.getId() != obj1.getId()) {
            return false;

        }
        if (!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())) {
            return false;

        }
        if (!this.getName().equals(obj1.getName())) {
            return false;

        }
        if (!this.getMenus().equals(obj1.getMenus())) {
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
    public MenuSize clone() throws CloneNotSupportedException {
        MenuSize obj = (MenuSize) super.clone();
        return obj;

    }

}