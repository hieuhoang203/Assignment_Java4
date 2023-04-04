package repositories;

import entity.NhanVien;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import untils.HibernateConfig;

import java.util.List;

public class NhanVienRepository {
    private final Session hSession;

    public NhanVienRepository() {
        this.hSession = HibernateConfig.getFACTORY().openSession();
    }

    public void insert(NhanVien nv){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(NhanVien nv){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(NhanVien nv){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public NhanVien findByMa(String ma){
        String hql = "select obj from NhanVien obj where obj.ma =: ma";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter("ma", ma);
        return query.getSingleResult();
    }

    public List<NhanVien> findAll() {
        String hql = "select obj from NhanVien obj";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        return query.getResultList();
    }

    public NhanVien login(String ma, String mat_khau){
        String hql = "SELECT nv FROM NhanVien nv WHERE nv.ma =: ma AND nv.mat_khau =: matKhau";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter("ma", ma);
        query.setParameter("matKhau", mat_khau);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
