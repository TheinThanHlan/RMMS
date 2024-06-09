
package dao;

import bean.Voucher;

import org.springframework.stereotype.Component;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:sql/Voucher.properties")
@Component()
public class VoucherDao {
    @Autowired()
    SessionFactory sf;

    public void create(Voucher data) {
        Session s = this.sf.openSession();
        try {
            Transaction tx = s.beginTransaction();
            s.save(data);
            tx.commit();

        } finally {
            s.close();
        }
    }

    public Voucher readFromId(long id) {
        Session s = this.sf.openSession();
        Voucher tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<Voucher>get(Voucher.class, id);
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public Voucher read(Voucher obj) {
        Session s = this.sf.openSession();
        Voucher tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            tmp = s.<Voucher>get(Voucher.class, obj.getId());
            tx.commit();
        } finally {
            s.close();
        }
        return tmp;

    }

    public void update(Voucher data) {
        Session s = this.sf.openSession();
        try {
            Transaction t = s.beginTransaction();
            s.persist(data);
            t.commit();

        } finally {
            s.close();
        }
    }

    public void delete(long id) {
        Session s = this.sf.openSession();
        try {
            Transaction t = s.beginTransaction();
            s.remove(this.readFromId(id));
            t.commit();

        } finally {
            s.close();
        }
    }

    public java.util.List<Voucher> readTodayOpenedVouchers(long restaurantId) {
        Session s = this.sf.openSession();
        java.util.List<Voucher> tmp = null;
        try {
            Transaction tx = s.beginTransaction();
            jakarta.persistence.Query query = s
                    .createQuery("from Voucher v where v.restaurant.id=" + restaurantId);

            tmp = query.getResultList();
            tx.commit();

        } finally {
            s.close();
        }
        return tmp;

    }

    public java.util.List<Voucher> readAllVouchers(Voucher voucher) {
        Session s = this.sf.openSession();
        java.util.List<Voucher> tmp = null;
        try {
            Transaction tx = s.beginTransaction();

            String sql = "from Voucher v where v.restaurant.id=:restaurantId ";
            if (voucher.getState().getId() != 0) {
                sql += "and v.state.id=:stateId";
            }
            if (voucher.getRowCreatedDateTime().getTime() != 0) {
                sql += "and Date(v.rowCreatedDateTime)=Date(:rowCreatedDateTime) ";
            }
            jakarta.persistence.Query query = s.createQuery(sql);
            query.setParameter("restaurantId", voucher.getRestaurant().getId());

            if (voucher.getState().getId() != 0) {
                query.setParameter("stateId", voucher.getState().getId());
            }
            if (voucher.getRowCreatedDateTime().getTime() != 0) {
                query.setParameter("rowCreatedDateTime", voucher.getRowCreatedDateTime());
            }
            tmp = query.getResultList();
            tx.commit();

        } finally {
            s.close();
        }
        return tmp;

    }

    public int closeVoucher(Voucher voucher) {
        Session s = this.sf.openSession();
        int i = 0;
        try {
            Transaction tx = s.beginTransaction();
            jakarta.persistence.Query q = s
                    .createQuery("update Voucher v set v.state.id=:stateId where v.id=:voucherId");
            q.setParameter("stateId", voucher.getState().getId());
            q.setParameter("voucherId", voucher.getId());
            i = q.executeUpdate();
            tx.commit();
        } finally {
            s.close();
        }
        return i;
    }

}
