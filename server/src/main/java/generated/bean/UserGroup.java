package bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import bean.Category;
import bean.Type;
import bean.User;

@Entity()

@Table()
public class UserGroup implements java.io.Serializable {

    @Id()

    @GeneratedValue()

    @Expose(serialize = true, deserialize = true)
    private long id;

    @CreationTimestamp()

    @Expose(serialize = true, deserialize = true)
    private java.sql.Timestamp rowCreatedDateTime;

    @OneToMany(mappedBy = "userGroup")

    @Expose(serialize = false, deserialize = true)
    private java.util.List<User> users;

    @Column(unique = true, nullable = false)
    @Expose(serialize = true, deserialize = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter()
    @Setter()
    @Expose(serialize = true, deserialize = true)
    private Type type;

    @Getter()
    @Setter()
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "recieveEmployeeGroups")
    @Expose(serialize = false, deserialize = true)
    private java.util.List<Category> recieveMenuCategories;

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

    public java.util.List<User> getUsers() {
        return this.users;

    }

    public void setUsers(java.util.List<User> users) {
        this.users = users;

    }

    public String getName() {
        return this.name;

    }

    public void setName(String name) {
        this.name = name;

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
        final UserGroup obj1 = (UserGroup) obj;
        if (this.getId() != obj1.getId()) {
            return false;

        }
        if (!this.getRowCreatedDateTime().equals(obj1.getRowCreatedDateTime())) {
            return false;

        }
        if (!this.getUsers().equals(obj1.getUsers())) {
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
    public UserGroup clone() throws CloneNotSupportedException {
        UserGroup obj = (UserGroup) super.clone();
        return obj;

    }

}
