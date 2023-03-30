package entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_hoaDon")
    private HoaDon id_hoaDon;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_chiTietSp")
    private ChiTietSanPham id_chiTietSp;

    @Column(name = "so_luong")
    private int so_luong;

    @Column(name = "don_gia")
    private double don_gia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(HoaDon id_hoaDon, ChiTietSanPham id_chiTietSp, int so_luong, double don_gia) {
        this.id_hoaDon = id_hoaDon;
        this.id_chiTietSp = id_chiTietSp;
        this.so_luong = so_luong;
        this.don_gia = don_gia;
    }

    public HoaDon getId_hoaDon() {
        return id_hoaDon;
    }

    public void setId_hoaDon(HoaDon id_hoaDon) {
        this.id_hoaDon = id_hoaDon;
    }

    public ChiTietSanPham getId_chiTietSp() {
        return id_chiTietSp;
    }

    public void setId_chiTietSp(ChiTietSanPham id_chiTietSp) {
        this.id_chiTietSp = id_chiTietSp;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public double getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(double don_gia) {
        this.don_gia = don_gia;
    }
}
