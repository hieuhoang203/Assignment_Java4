package viewModel;

import java.sql.Date;

public class NhanVien {
    private int id;
    private String ma;
    private String ho;
    private String ten_dem;
    private String ten;
    private String gioi_tinh;
    private Date ngay_sinh;
    private String dia_chi;
    private String sdt;
    private String mat_khau;
    private CuaHang id_cuaHang;
    private ChucVu id_chucVu;
    private int id_baoCao;
    private int trang_thai;

    public NhanVien() {
    }

    public NhanVien(int id, String ma, String ho, String ten_dem, String ten, String gioi_tinh, Date ngay_sinh, String dia_chi, String sdt, String mat_khau, CuaHang id_cuaHang, ChucVu id_chucVu, int id_baoCao, int trang_thai) {
        this.id = id;
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
        this.id_baoCao = id_baoCao;
        this.trang_thai = trang_thai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getId_baoCao() {
        return id_baoCao;
    }

    public void setId_baoCao(int id_baoCao) {
        this.id_baoCao = id_baoCao;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }
}
