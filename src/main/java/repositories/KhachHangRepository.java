package repositories;

import entity.KhachHang;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import untils.HibernateConfig;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    private Session hSession;

    public KhachHangRepository() {
        this.hSession = HibernateConfig.getFACTORY().openSession();
    }

    public void insert(KhachHang kh) {
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(KhachHang kh) {
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(KhachHang kh) {
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<KhachHang> findAll() {
        String hql = "select obj from KhachHang obj";
        TypedQuery<KhachHang> query = this.hSession.createQuery(hql, KhachHang.class);
        return query.getResultList();
    }

    public KhachHang findByMa(String ma) {
        String hql = "select obj from KhachHang obj where obj.ma =:ma";
        TypedQuery<KhachHang> query = this.hSession.createQuery(hql, KhachHang.class);
        query.setParameter("ma", ma);
        return query.getSingleResult();
    }

    public KhachHang findById(int id) {
        return this.hSession.find(KhachHang.class, id);
    }
}
