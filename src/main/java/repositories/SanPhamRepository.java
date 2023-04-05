package repositories;

import entity.SanPham;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import untils.HibernateConfig;

import java.util.List;


public class SanPhamRepository {
    private Session hSession;

    public SanPhamRepository() {
        this.hSession = HibernateConfig.getFACTORY().openSession();
    }

    public void insert(SanPham sp){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(SanPham sp) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(SanPham sp) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<SanPham> findAll() {
        String hql = "select obj from SanPham obj";
        TypedQuery<SanPham> query = this.hSession.createQuery(hql, SanPham.class);
        return query.getResultList();
    }

    public SanPham findByMa(String ma) {
        String hql = "select obj from SanPham obj where obj.ma =: ma";
        TypedQuery<SanPham> query = this.hSession.createQuery(hql, SanPham.class);
        query.setParameter("ma", ma);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public SanPham findByMa(int id) {
        return this.hSession.find(SanPham.class, id);
    }
}
