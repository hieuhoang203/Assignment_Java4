package repositories;

import entity.DongSp;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import untils.HibernateConfig;

import java.util.ArrayList;
import java.util.List;

public class DongSanPhamRepository {
    private Session hSession;

    public DongSanPhamRepository() {
        this.hSession = HibernateConfig.getFACTORY().openSession();
    }

    public void insert(DongSp dongSp) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(dongSp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(DongSp dongSp) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(dongSp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(DongSp dongSp) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(dongSp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public DongSp findByMa(String ma) {
        String hql = "select obj from DongSp obj where obj.ma =: ma";
        TypedQuery<DongSp> query = this.hSession.createQuery(hql, DongSp.class);
        query.setParameter("ma", ma);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<DongSp> findAll() {
        String hql = "select obj from DongSp obj";
        TypedQuery<DongSp> query = this.hSession.createQuery(hql, DongSp.class);
        return query.getResultList();
    }

    public DongSp findById(int id){
        return this.hSession.find(DongSp.class, id);
    }
}