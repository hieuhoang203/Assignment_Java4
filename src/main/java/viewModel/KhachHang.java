package viewModel;

import java.sql.Date;

public class KhachHang {
    private int id;
    private String ma;
    private String ho;
    private String ten_dem;
    private String ten;
    private Date ngay_sinh;
    private String sdt;
    private String dia_chi;
    private String thanh_pho;
    private String quoc_gia;
    private String mat_khau;

    public KhachHang() {
    }

    public KhachHang(int id, String ma, String ho, String ten_dem, String ten, Date ngay_sinh, String sdt, String dia_chi, String thanh_pho, String quoc_gia, String mat_khau) {
        this.id = id;
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
}
