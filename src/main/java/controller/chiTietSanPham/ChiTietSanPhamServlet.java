package controller.chiTietSanPham;

import entity.ChiTietSanPham;
import entity.SanPham;
import entity.MauSac;
import entity.NhaSanXuat;
import entity.DongSp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.*;


import java.io.IOException;
import java.util.UUID;

@WebServlet({
        "/chi-tiet-san-pham/create",
        "/chi-tiet-san-pham/store",
        "/chi-tiet-san-pham/index",
        "/chi-tiet-san-pham/delete",
        "/chi-tiet-san-pham/edit",
        "/chi-tiet-san-pham/update"
})
public class ChiTietSanPhamServlet extends HttpServlet {
    private ChiTietSanPhamRepository chiTietSanPhamRepository;
    private NhaSanXuatRepository nhaSanXuatRepository;
    private MauSacRepository mauSacRepository;
    private DongSanPhamRepository dongSanPhamRepository;
    private SanPhamRepository sanPhamRepository;

    public ChiTietSanPhamServlet() {
        chiTietSanPhamRepository = new ChiTietSanPhamRepository();
        nhaSanXuatRepository = new NhaSanXuatRepository();
        mauSacRepository = new MauSacRepository();
        dongSanPhamRepository = new DongSanPhamRepository();
        sanPhamRepository = new SanPhamRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")){
            this.create(request, response);
        } else if (uri.contains("delete")){
            this.delete(request, response);
        } else if (uri.contains("edit")){
            this.edit(request, response);
        } else {
            this.index(request, response);
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_ctsp", chiTietSanPhamRepository.findAll());
        request.setAttribute("view", "/views/chiTietSanPham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_ms", this.mauSacRepository.findAll());
        request.setAttribute("list_sp", this.sanPhamRepository.findAll());
        request.setAttribute("list_nsx", this.nhaSanXuatRepository.findAll());
        request.setAttribute("list_dsp", this.dongSanPhamRepository.findAll());

        UUID id = UUID.fromString(request.getParameter("id"));
        ChiTietSanPham ctsp = this.chiTietSanPhamRepository.findById(id);
        request.setAttribute("ctsp", ctsp);
        request.setAttribute("view", "/views/chiTietSanPham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        ChiTietSanPham ctsp = this.chiTietSanPhamRepository.findById(id);
        this.chiTietSanPhamRepository.delete(ctsp);
        response.sendRedirect("/chi-tiet-san-pham/index");
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_ms", this.mauSacRepository.findAll());
        request.setAttribute("list_sp", this.sanPhamRepository.findAll());
        request.setAttribute("list_nsx", this.nhaSanXuatRepository.findAll());
        request.setAttribute("list_dsp", this.dongSanPhamRepository.findAll());
        request.setAttribute("view", "/views/chiTietSanPham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")){
            this.store(request, response);
        } else if (uri.contains("update")){
            this.update(request, response);
        } else {
            this.index(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        ChiTietSanPham ctsp = this.chiTietSanPhamRepository.findById(id);
        SanPham id_sanPham = this.sanPhamRepository.findByMa(request.getParameter("id_sanPham"));
        NhaSanXuat id_nhaSanXuat = this.nhaSanXuatRepository.findByMa(request.getParameter("id_nhaSanXuat"));
        MauSac id_mauSac = this.mauSacRepository.findByMa(request.getParameter("id_mauSac"));
        DongSp id_dongSp = this.dongSanPhamRepository.findByMa(request.getParameter("id_dongSp"));
        int nam_bh = Integer.parseInt(request.getParameter("nam_bh"));
        String mo_ta = request.getParameter("mo_ta");
        int so_luong = Integer.parseInt(request.getParameter("so_luong"));
        double gia_nhap = Double.parseDouble(request.getParameter("gia_nhap"));
        double gia_ban = Double.parseDouble(request.getParameter("gia_ban"));

        ctsp.setId_sanPham(id_sanPham);
        ctsp.setId_nhaSanXuat(id_nhaSanXuat);
        ctsp.setId_mauSac(id_mauSac);
        ctsp.setId_dongSp(id_dongSp);
        ctsp.setNam_bh(nam_bh);
        ctsp.setMo_ta(mo_ta);
        ctsp.setSo_luong(so_luong);
        ctsp.setGia_ban(gia_ban);
        ctsp.setGia_nhap(gia_nhap);

        this.chiTietSanPhamRepository.update(ctsp);
        response.sendRedirect("/chi-tiet-san-pham/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPham id_sanPham = this.sanPhamRepository.findByMa(request.getParameter("id_sanPham"));
        NhaSanXuat id_nhaSanXuat = this.nhaSanXuatRepository.findByMa(request.getParameter("id_nhaSanXuat"));
        MauSac id_mauSac = this.mauSacRepository.findByMa(request.getParameter("id_mauSac"));
        DongSp id_dongSp = this.dongSanPhamRepository.findByMa(request.getParameter("id_dongSp"));
        int nam_bh = Integer.parseInt(request.getParameter("nam_bh"));
        String mo_ta = request.getParameter("mo_ta");
        int so_luong = Integer.parseInt(request.getParameter("so_luong"));
        double gia_nhap = Double.parseDouble(request.getParameter("gia_nhap"));
        double gia_ban = Double.parseDouble(request.getParameter("gia_ban"));

        ChiTietSanPham ctsp = new ChiTietSanPham(id_sanPham, id_nhaSanXuat, id_mauSac, id_dongSp, nam_bh, mo_ta, so_luong, gia_nhap, gia_ban);

        this.chiTietSanPhamRepository.insert(ctsp);
        response.sendRedirect("/chi-tiet-san-pham/index");
    }
}
