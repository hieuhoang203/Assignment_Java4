package repositories;

import entity.ChucVu;
import entity.DongSp;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import untils.HibernateConfig;

import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    private Session hSession;

    public ChucVuRepository() {
        this.hSession = HibernateConfig.getFACTORY().openSession();
    }

    public void insert(ChucVu cv) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.persist(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChucVu cv) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.merge(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChucVu cv) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.delete(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<ChucVu> findAll() {
        String hql = "select obj from ChucVu obj";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql, ChucVu.class);
        return query.getResultList();
    }

    public ChucVu findByMa(String ma){
        String hql = "select obj from ChucVu obj where obj.ma =: ma";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql, ChucVu.class);
        query.setParameter("ma", ma);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public ChucVu findById(UUID id){
        return this.hSession.find(ChucVu.class, id);
    }
}
