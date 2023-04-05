package controller.sanPham;

import entity.MauSac;
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
import repositories.SanPhamRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

@WebServlet({
        "/san-pham/create",
        "/san-pham/index",
        "/san-pham/store",
        "/san-pham/delete",
        "/san-pham/update",
        "/san-pham/edit"
})
public class SanPhamServlet extends HttpServlet {
    private final SanPhamRepository sanPhamRepository;

    public SanPhamServlet() {
        this.sanPhamRepository = new SanPhamRepository();
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
        request.setAttribute("view", "/views/sanPham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")){
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.index(request, response);
        }
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SanPham sp = new SanPham();
            BeanUtils.populate(sp, request.getParameterMap());
            HttpSession session = request.getSession();

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<SanPham>> constraints = validator.validate(sp);

            if (!constraints.isEmpty()){
                String errMa = "";
                String errTen = "";
                for (ConstraintViolation<SanPham> constraintViolation: constraints) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else {
                        errTen = constraintViolation.getMessage();
                    }
                }

                session.setAttribute("sp", sp);
                session.setAttribute("errMa", errMa);
                session.setAttribute("errTen", errTen);
                response.sendRedirect("/san-pham/create");
            } else {
                this.sanPhamRepository.insert(sp);
                session.removeAttribute("sp");
                session.removeAttribute("errMa");
                session.removeAttribute("errTen");
                response.sendRedirect("/san-pham/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_sp", this.sanPhamRepository.findAll());
        request.setAttribute("view", "/views/sanPham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        SanPham sp = this.sanPhamRepository.findByMa(ma);

        this.sanPhamRepository.delete(sp);
        response.sendRedirect("/san-pham/index");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SanPham sp = this.sanPhamRepository.findByMa(request.getParameter("ma"));
            BeanUtils.populate(sp, request.getParameterMap());
            HttpSession session = request.getSession();

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<SanPham>> constraints = validator.validate(sp);

            if (!constraints.isEmpty()){
                String errMa = "";
                String errTen = "";
                for (ConstraintViolation<SanPham> constraintViolation: constraints) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else {
                        errTen = constraintViolation.getMessage();
                    }
                }

                session.setAttribute("sp", sp);
                session.setAttribute("errMa", errMa);
                session.setAttribute("errTen", errTen);
                response.sendRedirect("/san-pham/edit");
            } else {
                this.sanPhamRepository.update(sp);
                session.removeAttribute("sp");
                session.removeAttribute("errMa");
                session.removeAttribute("errTen");
                response.sendRedirect("/san-pham/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/san-pham/index");
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp = this.sanPhamRepository.findByMa(ma);

        request.setAttribute("sp", sp);
        request.setAttribute("view", "/views/sanPham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
}
