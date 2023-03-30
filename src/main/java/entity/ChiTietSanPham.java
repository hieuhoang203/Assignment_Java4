package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
public class ChiTietSanPham implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_sanPham")
    private SanPham id_sanPham;

    @ManyToOne
    @JoinColumn(name = "id_nhaSanXuat")
    private NhaSanXuat id_nhaSanXuat;

    @ManyToOne
    @JoinColumn(name = "id_mauSac")
    private MauSac id_mauSac;

    @ManyToOne
    @JoinColumn(name = "id_dongSp")
    private DongSp id_dongSp;

    @Column(name = "nam_bh")
    private int nam_bh;

    @Column(name = "mo_ta")
    private String mo_ta;

    @Column(name = "so_luong_ton")
    private int so_luong;

    @Column(name = "gia_nhap")
    private double gia_nhap;

    @Column(name = "gia_ban")
    private double gia_ban;

    @OneToMany(mappedBy = "id_chiTietSp", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> hoaDonChiTiets;

    @OneToMany(mappedBy = "id_chiTietSp", fetch = FetchType.LAZY)
    private List<GioHangChiTiet> gioHangChiTiets;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(SanPham id_sanPham, NhaSanXuat id_nhaSanXuat, MauSac id_mauSac, DongSp id_dongSp, int nam_bh, String mo_ta, int so_luong, double gia_nhap, double gia_ban) {
        this.id_sanPham = id_sanPham;
        this.id_nhaSanXuat = id_nhaSanXuat;
        this.id_mauSac = id_mauSac;
        this.id_dongSp = id_dongSp;
        this.nam_bh = nam_bh;
        this.mo_ta = mo_ta;
        this.so_luong = so_luong;
        this.gia_nhap = gia_nhap;
        this.gia_ban = gia_ban;
    }

    public ChiTietSanPham(SanPham id_sanPham, NhaSanXuat id_nhaSanXuat, MauSac id_mauSac, DongSp id_dongSp, int nam_bh, String mo_ta, int so_luong, double gia_nhap, double gia_ban, List<HoaDonChiTiet> hoaDonChiTiets, List<GioHangChiTiet> gioHangChiTiets) {
        this.id_sanPham = id_sanPham;
        this.id_nhaSanXuat = id_nhaSanXuat;
        this.id_mauSac = id_mauSac;
        this.id_dongSp = id_dongSp;
        this.nam_bh = nam_bh;
        this.mo_ta = mo_ta;
        this.so_luong = so_luong;
        this.gia_nhap = gia_nhap;
        this.gia_ban = gia_ban;
        this.hoaDonChiTiets = hoaDonChiTiets;
        this.gioHangChiTiets = gioHangChiTiets;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SanPham getId_sanPham() {
        return id_sanPham;
    }

    public void setId_sanPham(SanPham id_sanPham) {
        this.id_sanPham = id_sanPham;
    }

    public NhaSanXuat getId_nhaSanXuat() {
        return id_nhaSanXuat;
    }

    public void setId_nhaSanXuat(NhaSanXuat id_nhaSanXuat) {
        this.id_nhaSanXuat = id_nhaSanXuat;
    }

    public MauSac getId_mauSac() {
        return id_mauSac;
    }

    public void setId_mauSac(MauSac id_mauSac) {
        this.id_mauSac = id_mauSac;
    }

    public DongSp getId_dongSp() {
        return id_dongSp;
    }

    public void setId_dongSp(DongSp id_dongSp) {
        this.id_dongSp = id_dongSp;
    }

    public int getNam_bh() {
        return nam_bh;
    }

    public void setNam_bh(int nam_bh) {
        this.nam_bh = nam_bh;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public double getGia_nhap() {
        return gia_nhap;
    }

    public void setGia_nhap(double gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public double getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(double gia_ban) {
        this.gia_ban = gia_ban;
    }

    public List<GioHangChiTiet> getGioHangChiTiets() {
        return gioHangChiTiets;
    }

    public void setGioHangChiTiets(List<GioHangChiTiet> gioHangChiTiets) {
        this.gioHangChiTiets = gioHangChiTiets;
    }

    public List<HoaDonChiTiet> getHoaDonChiTiets() {
        return hoaDonChiTiets;
    }

    public void setHoaDonChiTiets(List<HoaDonChiTiet> hoaDonChiTiets) {
        this.hoaDonChiTiets = hoaDonChiTiets;
    }
}
