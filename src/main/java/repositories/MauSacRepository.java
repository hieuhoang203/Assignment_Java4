package repositories;

import entity.MauSac;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import untils.HibernateConfig;

import java.util.List;

public class MauSacRepository {
    private Session hSession;

    public MauSacRepository() {
        this.hSession = HibernateConfig.getFACTORY().openSession();
    }

    public void insert(MauSac ms){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(MauSac ms) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(MauSac ms) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<MauSac> findAll() {
        String hql = "select obj from MauSac obj";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql, MauSac.class);
        return query.getResultList();
    }

    public MauSac findByMa(String ma){
        String hql = "select obj from MauSac obj where obj.ma =:ma";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql, MauSac.class);
        query.setParameter("ma", ma);
        return query.getSingleResult();
    }

    public MauSac findById(int id){
        return this.hSession.find(MauSac.class, id);
    }
}
