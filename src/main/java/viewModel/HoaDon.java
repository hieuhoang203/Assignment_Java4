package viewModel;

import java.sql.Date;

public class HoaDon {
    private int id;
    private KhachHang id_khachHang;
    private NhanVien id_nhanVien;
    private String ma;
    private Date ngay_tao;
    private Date ngay_thanh_toan;
    private Date ngay_ship;
    private Date ngay_nhan;
    private int tinh_trang;
    private String ten_nguoi_nhan;
    private String dia_chi;
    private String sdt;

    public HoaDon() {
    }

    public HoaDon(int id, KhachHang id_khachHang, NhanVien id_nhanVien, String ma, Date ngay_tao, Date ngay_thanh_toan, Date ngay_ship, Date ngay_nhan, int tinh_trang, String ten_nguoi_nhan, String dia_chi, String sdt) {
        this.id = id;
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
}
