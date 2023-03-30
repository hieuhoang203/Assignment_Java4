package entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GioHangChiTiet")
public class GioHangChiTiet implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gioHang")
    private GioHang id_gioHang;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chiTietSp")
    private ChiTietSanPham id_chiTietSp;

    @Column(name = "so_luong")
    private int so_luong;

    @Column(name = "don_gia")
    private double don_gia;

    @Column(name = "don_gia_khi_giam")
    private double don_gia_khi_giam;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(GioHang id_gioHang, ChiTietSanPham id_chiTietSp, int so_luong, double don_gia, double don_gia_khi_giam) {
        this.id_gioHang = id_gioHang;
        this.id_chiTietSp = id_chiTietSp;
        this.so_luong = so_luong;
        this.don_gia = don_gia;
        this.don_gia_khi_giam = don_gia_khi_giam;
    }

    public GioHang getId_gioHang() {
        return id_gioHang;
    }

    public void setId_gioHang(GioHang id_gioHang) {
        this.id_gioHang = id_gioHang;
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

    public double getDon_gia_khi_giam() {
        return don_gia_khi_giam;
    }

    public void setDon_gia_khi_giam(double don_gia_khi_giam) {
        this.don_gia_khi_giam = don_gia_khi_giam;
    }
}
