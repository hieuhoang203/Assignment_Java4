package controller.cuaHang;

import entity.CuaHang;
import entity.NhaSanXuat;
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
import repositories.CuaHangRepository;

import java.io.IOException;
import java.util.Set;

@WebServlet({
        "/cua-hang/index",
        "/cua-hang/create",
        "/cua-hang/delete",
        "/cua-hang/update",
        "/cua-hang/edit",
        "/cua-hang/store"
})
public class CuaHangServlet extends HttpServlet {
    private final CuaHangRepository cuaHangRepository;

    public CuaHangServlet() {
        cuaHangRepository = new CuaHangRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().contains("create")){
            this.create(request, response);
        } else if (request.getRequestURI().contains("edit")) {
            this.edit(request, response);
        } else if (request.getRequestURI().contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/cuaHang/create.jsp");
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

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            CuaHang ch = this.cuaHangRepository.findByMa(request.getParameter("ma"));
            BeanUtils.populate(ch, request.getParameterMap());
            HttpSession session = request.getSession();

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<CuaHang>> constraints = validator.validate(ch);

            if (!constraints.isEmpty()){
                String errMa = "";
                String errTen = "";
                String errDiachi = "";
                for (ConstraintViolation<CuaHang> constraintViolation: constraints) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else if (constraintViolation.getPropertyPath().toString().equals("ten")){
                        errTen = constraintViolation.getMessage();
                    } else {
                        errDiachi = constraintViolation.getMessage();
                    }
                }

                session.setAttribute("ch", ch);
                session.setAttribute("errMa", errMa);
                session.setAttribute("errTen", errTen);
                session.setAttribute("errDiachi", errDiachi);
                response.sendRedirect("/cua-hang/edit");
            } else {
                this.cuaHangRepository.update(ch);
                session.removeAttribute("ch");
                session.removeAttribute("errMa");
                session.removeAttribute("errTen");
                session.removeAttribute("errDiachi");
                response.sendRedirect("/cua-hang/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/cua-hang/index");
        }
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CuaHang ch = new CuaHang();
            BeanUtils.populate(ch, request.getParameterMap());
            HttpSession session = request.getSession();

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<CuaHang>> constraints = validator.validate(ch);

            if (!constraints.isEmpty()){
                String errMa = "";
                String errTen = "";
                String errDiachi = "";
                for (ConstraintViolation<CuaHang> constraintViolation: constraints) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else if (constraintViolation.getPropertyPath().toString().equals("ten")){
                        errTen = constraintViolation.getMessage();
                    } else {
                        errDiachi = constraintViolation.getMessage();
                    }
                }

                session.setAttribute("ch", ch);
                session.setAttribute("errMa", errMa);
                session.setAttribute("errTen", errTen);
                session.setAttribute("errDiachi", errDiachi);
                response.sendRedirect("/cua-hang/create");
            } else {
                this.cuaHangRepository.insert(ch);
                session.removeAttribute("ch");
                session.removeAttribute("errMa");
                session.removeAttribute("errTen");
                session.removeAttribute("errDiachi");
                response.sendRedirect("/cua-hang/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/cua-hang/index");
        }

    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_ch", this.cuaHangRepository.findAll());
        request.setAttribute("view", "/views/cuaHang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang ch = this.cuaHangRepository.findByMa(ma);

        this.cuaHangRepository.delete(ch);
        response.sendRedirect("/cua-hang/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang ch = this.cuaHangRepository.findByMa(ma);
        request.setAttribute("ch", ch);
        request.setAttribute("view", "/views/cuaHang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
}
