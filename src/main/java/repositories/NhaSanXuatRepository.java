package repositories;

import entity.NhaSanXuat;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import untils.HibernateConfig;

import java.util.List;


public class NhaSanXuatRepository {
    private Session hSession;

    public NhaSanXuatRepository() {
        this.hSession = HibernateConfig.getFACTORY().openSession();
    }

    public void insert(NhaSanXuat nsx){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(NhaSanXuat nsx){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(NhaSanXuat nsx){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<NhaSanXuat> findAll() {
        String hql = "select obj from NhaSanXuat obj";
        TypedQuery<NhaSanXuat> query = this.hSession.createQuery(hql, NhaSanXuat.class);
        return query.getResultList();
    }

    public NhaSanXuat findByMa(String ma){
        String hql = "select obj from NhaSanXuat obj where obj.ma =: ma";
        TypedQuery<NhaSanXuat> query = this.hSession.createQuery(hql, NhaSanXuat.class);
        query.setParameter("ma", ma);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public NhaSanXuat findById(int id){
        return this.hSession.find(NhaSanXuat.class, id);
    }
}
