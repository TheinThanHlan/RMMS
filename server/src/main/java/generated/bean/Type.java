package bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.Category;
import bean.State;

@Entity()

@Table()
public class Type implements java.io.Serializable {

    @Id()

    @GeneratedValue()

    @Expose(serialize = true, deserialize = true)

    @Getter()

    @Setter()
    private long id;

    @Column(unique = true, nullable = false)

    @Expose(serialize = true, deserialize = true)

    @Getter()

    @Setter()
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")

    @Expose(serialize = false, deserialize = true)

    @Getter()

    @Setter()
    private java.util.List<Category> categories;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
    @Expose(serialize = false, deserialize = true)
    @Getter()
    @Setter()
    private java.util.List<State> states;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
    @Expose(serialize = false, deserialize = true)
    @Getter()
    @Setter()
    private java.util.List<UserGroup> userGroups;

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
        final Type obj1 = (Type) obj;
        if (this.getId() != obj1.getId()) {
            return false;

        }
        if (!this.getName().equals(obj1.getName())) {
            return false;

        }
        if (!this.getCategories().equals(obj1.getCategories())) {
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
    public Type clone() throws CloneNotSupportedException {
        Type obj = (Type) super.clone();
        return obj;

    }

}
