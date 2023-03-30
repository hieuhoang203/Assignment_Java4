package viewModel;

import java.sql.Date;

public class GioHang {
    private int id;
    private KhachHang id_khachHang;
    private NhanVien id_nhanVien;
    private String ma;
    private Date ngay_tao;
    private Date ngay_thanh_toan;
    private String ten_nguoi_nhanh;
    private String dia_chi;
    private String sdt;
    private int trang_thai;

    public GioHang() {
    }

    public GioHang(int id, KhachHang id_khachHang, NhanVien id_nhanVien, String ma, Date ngay_tao, Date ngay_thanh_toan, String ten_nguoi_nhanh, String dia_chi, String sdt, int trang_thai) {
        this.id = id;
        this.id_khachHang = id_khachHang;
        this.id_nhanVien = id_nhanVien;
        this.ma = ma;
        this.ngay_tao = ngay_tao;
        this.ngay_thanh_toan = ngay_thanh_toan;
        this.ten_nguoi_nhanh = ten_nguoi_nhanh;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
        this.trang_thai = trang_thai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getTen_nguoi_nhanh() {
        return ten_nguoi_nhanh;
    }

    public void setTen_nguoi_nhanh(String ten_nguoi_nhanh) {
        this.ten_nguoi_nhanh = ten_nguoi_nhanh;
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

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }
}
