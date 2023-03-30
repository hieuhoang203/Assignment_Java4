package repositories;

import entity.CuaHang;
import entity.DongSp;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import untils.HibernateConfig;

import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    private Session hSession;

    public CuaHangRepository() {
        this.hSession = HibernateConfig.getFACTORY().openSession();
    }

    public void insert(CuaHang ch) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(CuaHang ch) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(CuaHang ch) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<CuaHang> findAll() {
        String hql = "select obj from CuaHang obj";
        TypedQuery<CuaHang> query = this.hSession.createQuery(hql, CuaHang.class);
        return query.getResultList();
    }

    public CuaHang findByMa(String ma) {
        String hql = "select obj from CuaHang obj where obj.ma =: ma";
        TypedQuery<CuaHang> query = this.hSession.createQuery(hql, CuaHang.class);
        query.setParameter("ma", ma);
        return query.getSingleResult();
    }

    public CuaHang findById(UUID id) {
        return this.hSession.find(CuaHang.class, id);
    }
}
