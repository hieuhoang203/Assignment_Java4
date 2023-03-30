package controller.nhanVien;

import entity.ChucVu;
import entity.CuaHang;
import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChucVuRepository;
import repositories.CuaHangRepository;
import repositories.NhanVienRepository;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet({
        "/nhan-vien/index",
        "/nhan-vien/create",
        "/nhan-vien/delete",
        "/nhan-vien/store",
        "/nhan-vien/edit",
        "/nhan-vien/update"
})
public class NhanVienServlet extends HttpServlet {
    private final NhanVienRepository nhanVienRepository;
    private final CuaHangRepository cuaHangRepository;
    private final ChucVuRepository chucVuRepository;

    public NhanVienServlet() {
        this.nhanVienRepository = new NhanVienRepository();
        this.cuaHangRepository = new CuaHangRepository();
        this.chucVuRepository = new ChucVuRepository();
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

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_cv", this.chucVuRepository.findAll());
        request.setAttribute("list_ch", this.cuaHangRepository.findAll());
        String ma = request.getParameter("ma");
        NhanVien nv = this.nhanVienRepository.findByMa(ma);

        request.setAttribute("nv", nv);
        request.setAttribute("view", "/views/nhanVien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_nv", this.nhanVienRepository.findAll());
        request.setAttribute("view", "/views/nhanVien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = this.nhanVienRepository.findByMa(ma);

        this.nhanVienRepository.delete(nv);
        response.sendRedirect("/nhan-vien/index");
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_cv", this.chucVuRepository.findAll());
        request.setAttribute("list_ch", this.cuaHangRepository.findAll());
        request.setAttribute("view", "/views/nhanVien/create.jsp");
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
        NhanVien nv = this.nhanVienRepository.findByMa(request.getParameter("ma"));
        String ho = request.getParameter("ho");
        String ten_dem = request.getParameter("ten_dem");
        String ten = request.getParameter("ten");
        String gioi_tinh = request.getParameter("gioi_tinh");
        Date ngay_sinh = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngay_sinh"));
        String dia_chi = request.getParameter("dia_chi");
        String sdt = request.getParameter("sdt");
        String mat_khau = request.getParameter("mat_khau");
        CuaHang id_cuaHang = this.cuaHangRepository.findByMa(request.getParameter("id_cuaHang"));
        ChucVu id_chucVu = this.chucVuRepository.findByMa(request.getParameter("id_chucVu"));
        int trang_thai = 1;
        if (request.getParameter("trang_thai") == null){
            trang_thai = 0;
        }
        nv.setHo(ho);
        nv.setTen_dem(ten_dem);
        nv.setTen(ten);
        nv.setGioi_tinh(gioi_tinh);
        nv.setNgay_sinh(new java.sql.Date(ngay_sinh.getTime()));
        nv.setDia_chi(dia_chi);
        nv.setSdt(sdt);
        nv.setMat_khau(mat_khau);
        nv.setId_cuaHang(id_cuaHang);
        nv.setId_chucVu(id_chucVu);
        nv.setTrang_thai(trang_thai);
        this.nhanVienRepository.update(nv);
        response.sendRedirect("/nhan-vien/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String ten_dem = request.getParameter("ten_dem");
        String ten = request.getParameter("ten");
        String gioi_tinh = request.getParameter("gioi_tinh");
        Date ngay_sinh = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngay_sinh"));
        String dia_chi = request.getParameter("dia_chi");
        String sdt = request.getParameter("sdt");
        String mat_khau = request.getParameter("mat_khau");
        CuaHang id_cuaHang = this.cuaHangRepository.findByMa(request.getParameter("id_cuaHang"));
        ChucVu id_chucVu = this.chucVuRepository.findByMa(request.getParameter("id_chucVu"));
        int trang_thai = 1;
        if (request.getParameter("trang_thai") == null){
            trang_thai = 0;
        }
        NhanVien nv = new NhanVien(ma, ho, ten_dem, ten, gioi_tinh, new java.sql.Date(ngay_sinh.getTime()), dia_chi, sdt, mat_khau, id_cuaHang, id_chucVu, trang_thai);
        this.nhanVienRepository.insert(nv);
        response.sendRedirect("/nhan-vien/index");
    }
}
