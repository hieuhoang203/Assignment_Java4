package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable {
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

    @Column(name = "ma")
    private String ma;

    @Column(name = "ho")
    private String ho;

    @Column(name = "ten_dem")
    private String ten_dem;

    @Column(name = "ten")
    private String ten;

    @Column(name = "ngay_sinh")
    @Temporal(TemporalType.DATE)
    private Date ngay_sinh;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "dia_chi")
    private String dia_chi;

    @Column(name = "thanh_pho")
    private String thanh_pho;

    @Column(name = "quoc_gia")
    private String quoc_gia;

    @Column(name = "mat_khau")
    private String mat_khau;

    @OneToMany(mappedBy = "id_khachHang", fetch = FetchType.LAZY)
    private List<HoaDon> hoaDons;

    @OneToMany(mappedBy = "id_khachHang", fetch = FetchType.LAZY)
    private List<GioHang> gioHangs;

    public KhachHang() {
    }

    public KhachHang(String ma, String ho, String ten_dem, String ten, Date ngay_sinh, String sdt, String dia_chi, String thanh_pho, String quoc_gia, String mat_khau) {
        this.ma = ma;
        this.ho = ho;
        this.ten_dem = ten_dem;
        this.ten = ten;
        this.ngay_sinh = ngay_sinh;
        this.sdt = sdt;
        this.dia_chi = dia_chi;
        this.thanh_pho = thanh_pho;
        this.quoc_gia = quoc_gia;
        this.mat_khau = mat_khau;
    }

    public KhachHang(String ma, String ho, String ten_dem, String ten, Date ngay_sinh, String sdt, String dia_chi, String thanh_pho, String quoc_gia, String mat_khau, List<HoaDon> hoaDons, List<GioHang> gioHangs) {
        this.ma = ma;
        this.ho = ho;
        this.ten_dem = ten_dem;
        this.ten = ten;
        this.ngay_sinh = ngay_sinh;
        this.sdt = sdt;
        this.dia_chi = dia_chi;
        this.thanh_pho = thanh_pho;
        this.quoc_gia = quoc_gia;
        this.mat_khau = mat_khau;
        this.hoaDons = hoaDons;
        this.gioHangs = gioHangs;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen_dem() {
        return ten_dem;
    }

    public void setTen_dem(String ten_dem) {
        this.ten_dem = ten_dem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getThanh_pho() {
        return thanh_pho;
    }

    public void setThanh_pho(String thanh_pho) {
        this.thanh_pho = thanh_pho;
    }

    public String getQuoc_gia() {
        return quoc_gia;
    }

    public void setQuoc_gia(String quoc_gia) {
        this.quoc_gia = quoc_gia;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    public List<GioHang> getGioHangs() {
        return gioHangs;
    }

    public void setGioHangs(List<GioHang> gioHangs) {
        this.gioHangs = gioHangs;
    }
}
