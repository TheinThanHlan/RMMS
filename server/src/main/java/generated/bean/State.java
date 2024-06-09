package bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import bean.Marsta;
import bean.MenuOrder;
import bean.OrderStatus;
import bean.Table_;
import bean.Restaurant;
import bean.AccountTransaction;
import bean.UserGroup;
import lombok.Getter;
import lombok.Setter;
import bean.Type;

@Entity()

@Table()
public class State implements java.io.Serializable {

    @Id()

    @GeneratedValue()

    @Expose(serialize = true, deserialize = true)
    private long id;

    @Column(nullable = false)

    @Expose(serialize = true, deserialize = true)
    private String name;

    @Getter()
    @Setter()
    @Expose(serialize = true, deserialize = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Type type;

    @Column()

    @Expose(serialize = true, deserialize = true)
    private String guiColor;

    @Column()

    @Expose(serialize = true, deserialize = true)
    private String guiClasses;

    @Column()

    @Expose(serialize = true, deserialize = true)
    private String moreInfo;

    @OneToMany(fetch = FetchType.LAZY)
    @Getter()
    @Setter()
    @Expose(serialize = false, deserialize = true)
    private java.util.List<Table_> table_s;

    @OneToMany(fetch = FetchType.LAZY)
    @Expose(serialize = false, deserialize = true)
    @Setter()
    @Getter()
    private java.util.List<Voucher> vouchers;

    @Getter()
    @Setter()
    @OneToMany(mappedBy = "orderState", fetch = FetchType.LAZY)
    @Expose(serialize = false, deserialize = true)
    private java.util.List<MenuOrder> orders;

    public long getId() {
        return this.id;

    }

    public void setId(long id) {
        this.id = id;

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

    public String getGuiClasses() {
        return this.guiClasses;

    }

    public void setGuiClasses(String guiClasses) {
        this.guiClasses = guiClasses;

    }

    public String getMoreInfo() {
        return this.moreInfo;

    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;

    }

    public String toJson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this);

    }

    public String toString() {
        {
            return this.toJson();

        }

    }

    @Override()
    public State clone() throws CloneNotSupportedException {
        State obj = (State) super.clone();
        return obj;

    }

}
