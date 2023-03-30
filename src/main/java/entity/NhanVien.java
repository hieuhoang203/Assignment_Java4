package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable {
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

    @Column(name = "gioi_tinh")
    private String gioi_tinh;

    @Column(name = "ngay_sinh")
    @Temporal(TemporalType.DATE)
    private Date ngay_sinh;

    @Column(name = "dia_chi")
    private String dia_chi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "mat_khau")
    private String mat_khau;

    @ManyToOne
    @JoinColumn(name = "id_cuaHang")
    private CuaHang id_cuaHang;

    @ManyToOne
    @JoinColumn(name = "id_chucVu")
    private ChucVu id_chucVu;

    @Column(name = "id_baoCao")
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
    private UUID id_baoCao;

    @Column(name = "trang_thai")
    private int trang_thai;

    @OneToMany(mappedBy = "id_nhanVien", fetch = FetchType.LAZY)
    private List<HoaDon> hoaDons;

    @OneToMany(mappedBy = "id_nhanVien", fetch = FetchType.LAZY)
    private List<GioHang> gioHangs;

    public NhanVien() {
    }

    public NhanVien(String ma, String ho, String ten_dem, String ten, String gioi_tinh, Date ngay_sinh, String dia_chi, String sdt, String mat_khau, CuaHang id_cuaHang, ChucVu id_chucVu, int trang_thai) {
        this.ma = ma;
        this.ho = ho;
        this.ten_dem = ten_dem;
        this.ten = ten;
        this.gioi_tinh = gioi_tinh;
        this.ngay_sinh = ngay_sinh;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
        this.mat_khau = mat_khau;
        this.id_cuaHang = id_cuaHang;
        this.id_chucVu = id_chucVu;
        this.trang_thai = trang_thai;
    }

    public NhanVien(String ma, String ho, String ten_dem, String ten, String gioi_tinh, Date ngay_sinh, String dia_chi, String sdt, String mat_khau, CuaHang id_cuaHang, ChucVu id_chucVu, int trang_thai, List<HoaDon> hoaDons, List<GioHang> gioHangs) {
        this.ma = ma;
        this.ho = ho;
        this.ten_dem = ten_dem;
        this.ten = ten;
        this.gioi_tinh = gioi_tinh;
        this.ngay_sinh = ngay_sinh;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
        this.mat_khau = mat_khau;
        this.id_cuaHang = id_cuaHang;
        this.id_chucVu = id_chucVu;
        this.trang_thai = trang_thai;
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

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
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

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public CuaHang getId_cuaHang() {
        return id_cuaHang;
    }

    public void setId_cuaHang(CuaHang id_cuaHang) {
        this.id_cuaHang = id_cuaHang;
    }

    public ChucVu getId_chucVu() {
        return id_chucVu;
    }

    public void setId_chucVu(ChucVu id_chucVu) {
        this.id_chucVu = id_chucVu;
    }

    public UUID getId_baoCao() {
        return id_baoCao;
    }

    public void setId_baoCao(UUID id_baoCao) {
        this.id_baoCao = id_baoCao;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
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
