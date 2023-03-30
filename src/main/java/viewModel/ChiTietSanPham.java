package viewModel;

public class ChiTietSanPham {
    private int id;
    private SanPham id_sanPham;
    private NhaSanXuat id_nhaSanXuat;
    private MauSac id_mauSac;
    private DongSp id_dongSp;
    private int nam_bh;
    private String mo_ta;
    private int so_luong;
    private double gia_nhap;
    private double gia_ban;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(int id, SanPham id_sanPham, NhaSanXuat id_nhaSanXuat, MauSac id_mauSac, DongSp id_dongSp, int nam_bh, String mo_ta, int so_luong, double gia_nhap, double gia_ban) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
