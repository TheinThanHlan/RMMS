package bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.MenuTemplate;
import bean.UserGroup;
import bean.Type;
import bean.MenuSize;

@Entity()

@Table()
public class Category implements java.io.Serializable {

    @Id()
    @GeneratedValue()
    @Expose(serialize = true, deserialize = true)
    @Getter()
    @Setter()
    private long id;

    @Column(nullable = false)
    @Expose(serialize = true, deserialize = true)
    @Getter()
    @Setter()
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @Expose(serialize = true, deserialize = true)
    @Getter()
    @Setter()
    private Type type;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")

    @Expose(serialize = true, deserialize = true)

    @Getter()

    @Setter()
    private java.util.List<Category> subCategories;

    @ManyToOne(fetch = FetchType.LAZY)

    @Expose(serialize = false, deserialize = true)

    @Getter()

    @Setter()
    private Category category;

    @Getter()
    @Setter()
    @OneToMany(mappedBy = "category")
    @Expose(serialize = false, deserialize = true)
    private java.util.List<MenuTemplate> menuTemplates;

    @Getter()
    @Setter()
    @OneToMany(mappedBy = "category")
    @Expose(serialize = false, deserialize = true)
    private java.util.List<MenuSize> MenuSize;

    @Getter()
    @Setter()
    @ManyToMany(fetch = FetchType.EAGER)
    @Expose(serialize = true, deserialize = true)
    private java.util.List<UserGroup> recieveEmployeeGroups;

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
        final Category obj1 = (Category) obj;
        if (this.getId() != obj1.getId()) {
            return false;

        }
        if (!this.getName().equals(obj1.getName())) {
            return false;

        }
        if (!this.getType().equals(obj1.getType())) {
            return false;

        }
        if (!this.getSubCategories().equals(obj1.getSubCategories())) {
            return false;

        }
        if (!this.getCategory().equals(obj1.getCategory())) {
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
    public Category clone() throws CloneNotSupportedException {
        Category obj = (Category) super.clone();
        return obj;

    }

}
