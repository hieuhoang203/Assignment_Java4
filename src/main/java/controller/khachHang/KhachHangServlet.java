package controller.khachHang;

import entity.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet({
        "/khach-hang/create",
        "/khach-hang/index",
        "/khach-hang/delete",
        "/khach-hang/store",
        "/khach-hang/edit",
        "/khach-hang/update"
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khachRepo;

    public KhachHangServlet() {
        this.khachRepo = new KhachHangRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")){
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/khachHang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")){
            try {
                this.store(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (uri.contains("update")) {
            try {
                this.update(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else {
            this.index(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        KhachHang kh = this.khachRepo.findByMa(request.getParameter("ma"));
        String ten_dem = request.getParameter("ten_dem");
        Date ngay_sinh = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngay_sinh"));
        String dia_chi = request.getParameter("dia_chi");
        String quoc_gia = request.getParameter("quoc_gia");
        String ho = request.getParameter("ho");
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
        String thanh_pho = request.getParameter("thanh_pho");
        String mat_khau = request.getParameter("mat_khau");
        kh.setHo(ho);
        kh.setTen_dem(ten_dem);
        kh.setTen(ten);
        kh.setNgay_sinh(new java.sql.Date(ngay_sinh.getTime()));
        kh.setSdt(sdt);
        kh.setDia_chi(dia_chi);
        kh.setThanh_pho(thanh_pho);
        kh.setQuoc_gia(quoc_gia);
        kh.setMat_khau(mat_khau);
        this.khachRepo.update(kh);
        response.sendRedirect("/khach-hang/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String ma = request.getParameter("ma");
        String ten_dem = request.getParameter("ten_dem");
        Date ngay_sinh = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngay_sinh"));
        String dia_chi = request.getParameter("dia_chi");
        String quoc_gia = request.getParameter("quoc_gia");
        String ho = request.getParameter("ho");
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
        String thanh_pho = request.getParameter("thanh_pho");
        String mat_khau = request.getParameter("mat_khau");
        KhachHang kh = new KhachHang(ma, ho, ten_dem, ten, new java.sql.Date(ngay_sinh.getTime()), sdt, dia_chi, thanh_pho, quoc_gia, mat_khau);
        this.khachRepo.insert(kh);
        response.sendRedirect("/khach-hang/index");
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_kh", this.khachRepo.findAll());
        request.setAttribute("view", "/views/khachHang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang kh = this.khachRepo.findByMa(ma);

        this.khachRepo.delete(kh);
        response.sendRedirect("/khach-hang/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang kh = this.khachRepo.findByMa(ma);

        request.setAttribute("kh", kh);
        request.setAttribute("view", "/views/khachHang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
}
