package repositories;

import entity.ChiTietSanPham;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import untils.HibernateConfig;

import java.util.List;
import java.util.UUID;

public class ChiTietSanPhamRepository {
    private Session hSession;

    public ChiTietSanPhamRepository(){
        hSession = HibernateConfig.getFACTORY().openSession();
    }

    public void insert(ChiTietSanPham ctsp){
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChiTietSanPham ctsp){
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChiTietSanPham ctsp){
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public ChiTietSanPham findById(UUID id){
        return this.hSession.find(ChiTietSanPham.class, id);
    }

    public List<ChiTietSanPham> findAll() {
        String hql = "select obj from ChiTietSanPham obj";
        TypedQuery<ChiTietSanPham> query = hSession.createQuery(hql, ChiTietSanPham.class);
        return query.getResultList();
    }
}
