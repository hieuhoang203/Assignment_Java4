package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "HoaDon")
public class HoaDon implements Serializable {
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
    @JoinColumn(name = "id_khachHang")
    private KhachHang id_khachHang;

    @ManyToOne
    @JoinColumn(name = "id_nhanVien")
    private NhanVien id_nhanVien;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ngay_tao")
    @Temporal(TemporalType.DATE)
    private Date ngay_tao;

    @Column(name = "ngay_thanh_toan")
    @Temporal(TemporalType.DATE)
    private Date ngay_thanh_toan;

    @Column(name = "ngay_ship")
    @Temporal(TemporalType.DATE)
    private Date ngay_ship;

    @Column(name = "ngay_nhan")
    @Temporal(TemporalType.DATE)
    private Date ngay_nhan;

    @Column(name = "tinh_trang")
    private int tinh_trang;

    @Column(name = "ten_nguoi_nhan")
    private String ten_nguoi_nhan;

    @Column(name = "dia_chi")
    private String dia_chi;

    @Column(name = "sdt")
    private String sdt;

    @OneToMany(mappedBy = "id_hoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> hoaDonChiTiets;

    public HoaDon() {
    }

    public HoaDon(KhachHang id_khachHang, NhanVien id_nhanVien, String ma, Date ngay_tao, Date ngay_thanh_toan, Date ngay_ship, Date ngay_nhan, int tinh_trang, String ten_nguoi_nhan, String dia_chi, String sdt) {
        this.id_khachHang = id_khachHang;
        this.id_nhanVien = id_nhanVien;
        this.ma = ma;
        this.ngay_tao = ngay_tao;
        this.ngay_thanh_toan = ngay_thanh_toan;
        this.ngay_ship = ngay_ship;
        this.ngay_nhan = ngay_nhan;
        this.tinh_trang = tinh_trang;
        this.ten_nguoi_nhan = ten_nguoi_nhan;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
    }

    public HoaDon(KhachHang id_khachHang, NhanVien id_nhanVien, String ma, Date ngay_tao, Date ngay_thanh_toan, Date ngay_ship, Date ngay_nhan, int tinh_trang, String ten_nguoi_nhan, String dia_chi, String sdt, List<HoaDonChiTiet> hoaDonChiTiets) {
        this.id_khachHang = id_khachHang;
        this.id_nhanVien = id_nhanVien;
        this.ma = ma;
        this.ngay_tao = ngay_tao;
        this.ngay_thanh_toan = ngay_thanh_toan;
        this.ngay_ship = ngay_ship;
        this.ngay_nhan = ngay_nhan;
        this.tinh_trang = tinh_trang;
        this.ten_nguoi_nhan = ten_nguoi_nhan;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
        this.hoaDonChiTiets = hoaDonChiTiets;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public KhachHang getId_khachHang() {
        return id_khachHang;
    }

    public void setId_khachHang(KhachHang id_khachHang) {
        this.id_khachHang = id_khachHang;
    }

    public NhanVien getId_nhanVien() {
        return id_nhanVien;
    }

    public void setId_nhanVien(NhanVien id_nhanVien) {
        this.id_nhanVien = id_nhanVien;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgay_tao() {
        return ngay_tao;
    }

    public void setNgay_tao(Date ngay_tao) {
        this.ngay_tao = ngay_tao;
    }

    public Date getNgay_thanh_toan() {
        return ngay_thanh_toan;
    }

    public void setNgay_thanh_toan(Date ngay_thanh_toan) {
        this.ngay_thanh_toan = ngay_thanh_toan;
    }

    public Date getNgay_ship() {
        return ngay_ship;
    }

    public void setNgay_ship(Date ngay_ship) {
        this.ngay_ship = ngay_ship;
    }

    public Date getNgay_nhan() {
        return ngay_nhan;
    }

    public void setNgay_nhan(Date ngay_nhan) {
        this.ngay_nhan = ngay_nhan;
    }

    public int getTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(int tinh_trang) {
        this.tinh_trang = tinh_trang;
    }

    public String getTen_nguoi_nhan() {
        return ten_nguoi_nhan;
    }

    public void setTen_nguoi_nhan(String ten_nguoi_nhan) {
        this.ten_nguoi_nhan = ten_nguoi_nhan;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public List<HoaDonChiTiet> getHoaDonChiTiets() {
        return hoaDonChiTiets;
    }

    public void setHoaDonChiTiets(List<HoaDonChiTiet> hoaDonChiTiets) {
        this.hoaDonChiTiets = hoaDonChiTiets;
    }
}
