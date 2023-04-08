package controller.khachHang;

import entity.KhachHang;
import entity.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.zip.DataFormatException;

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
        String errMa = "";
        String errTendem = "";
        String errHo = "";
        String errTen = "";
        String errNgaysinh = "";
        String errDiachi = "";
        String errSdt = "";
        String errMatkhau = "";
        HttpSession session = request.getSession();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<KhachHang>> constraints = validator.validate(kh);
        if (!constraints.isEmpty()){
            for (ConstraintViolation<KhachHang> constraintViolation: constraints) {
                if (constraintViolation.getPropertyPath().toString().equals("ma")){
                    errMa = constraintViolation.getMessage();
                } else if (constraintViolation.getPropertyPath().toString().equals("ho")){
                    errHo = constraintViolation.getMessage();
                } else if (constraintViolation.getPropertyPath().toString().equals("ten_dem")){
                    errTendem = constraintViolation.getMessage();
                } else if (constraintViolation.getPropertyPath().toString().equals("ten")){
                    errTen = constraintViolation.getMessage();
                } else if (constraintViolation.getPropertyPath().toString().equals("ngay_sinh")){
                    errNgaysinh = constraintViolation.getMessage();
                } else if (constraintViolation.getPropertyPath().toString().equals("dia_chi")){
                    errDiachi = constraintViolation.getMessage();
                } else if (constraintViolation.getPropertyPath().toString().equals("sdt")){
                    errSdt = constraintViolation.getMessage();
                } else {
                    errMatkhau = constraintViolation.getMessage();
                }
            }
            session.setAttribute("kh", kh);
            session.setAttribute("errMa", errMa);
            session.setAttribute("errHo", errHo);
            session.setAttribute("errTendem", errTendem);
            session.setAttribute("errTen", errTen);
            session.setAttribute("errNgaysinh", errNgaysinh);
            session.setAttribute("errDiachi", errDiachi);
            session.setAttribute("errSdt", errSdt);
            session.setAttribute("errMatkhau", errMatkhau);
            response.sendRedirect("/khach-hang/edit");
        } else {
            this.khachRepo.update(kh);
            session.removeAttribute("kh");
            session.removeAttribute("errMa");
            session.removeAttribute("errHo");
            session.removeAttribute("errTendem");
            session.removeAttribute("errTen");
            session.removeAttribute("errNgaysinh");
            session.removeAttribute("errDiachi");
            session.removeAttribute("errSdt");
            session.removeAttribute("errMatkhau");
            response.sendRedirect("/khach-hang/index");
        }
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String ma = request.getParameter("ma");
        String ten_dem = request.getParameter("ten_dem");
        Date ngay_sinh;
        try {
            ngay_sinh = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngay_sinh"));
        } catch (Exception e){
            ngay_sinh = new Date();
        }
        String dia_chi = request.getParameter("dia_chi");
        String quoc_gia = request.getParameter("quoc_gia");
        String ho = request.getParameter("ho");
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
        String thanh_pho = request.getParameter("thanh_pho");
        String mat_khau = request.getParameter("mat_khau");
        KhachHang kh = new KhachHang(ma, ho, ten_dem, ten, new java.sql.Date(ngay_sinh.getTime()), sdt, dia_chi, thanh_pho, quoc_gia, mat_khau);
        String errMa = "";
        String errTendem = "";
        String errHo = "";
        String errTen = "";
        String errNgaysinh = "";
        String errDiachi = "";
        String errSdt = "";
        String errMatkhau = "";
        HttpSession session = request.getSession();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<KhachHang>> constraints = validator.validate(kh);
        if (!constraints.isEmpty()){
            for (ConstraintViolation<KhachHang> constraintViolation: constraints) {
                if (constraintViolation.getPropertyPath().toString().equals("ma")){
                    errMa = constraintViolation.getMessage();
                } else if (constraintViolation.getPropertyPath().toString().equals("ho")){
                    errHo = constraintViolation.getMessage();
                } else if (constraintViolation.getPropertyPath().toString().equals("ten_dem")){
                    errTendem = constraintViolation.getMessage();
                } else if (constraintViolation.getPropertyPath().toString().equals("ten")){
                    errTen = constraintViolation.getMessage();
                } else if (constraintViolation.getPropertyPath().toString().equals("ngay_sinh")){
                    errNgaysinh = constraintViolation.getMessage();
                } else if (constraintViolation.getPropertyPath().toString().equals("dia_chi")){
                    errDiachi = constraintViolation.getMessage();
                } else if (constraintViolation.getPropertyPath().toString().equals("sdt")){
                    errSdt = constraintViolation.getMessage();
                } else {
                    errMatkhau = constraintViolation.getMessage();
                }
            }
            session.setAttribute("kh", kh);
            session.setAttribute("errMa", errMa);
            session.setAttribute("errHo", errHo);
            session.setAttribute("errTendem", errTendem);
            session.setAttribute("errTen", errTen);
            session.setAttribute("errNgaysinh", errNgaysinh);
            session.setAttribute("errDiachi", errDiachi);
            session.setAttribute("errSdt", errSdt);
            session.setAttribute("errMatkhau", errMatkhau);
            response.sendRedirect("/khach-hang/create");
        } else {
            this.khachRepo.insert(kh);
            session.removeAttribute("kh");
            session.removeAttribute("errMa");
            session.removeAttribute("errHo");
            session.removeAttribute("errTendem");
            session.removeAttribute("errTen");
            session.removeAttribute("errNgaysinh");
            session.removeAttribute("errDiachi");
            session.removeAttribute("errSdt");
            session.removeAttribute("errMatkhau");
            response.sendRedirect("/khach-hang/index");
        }
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
