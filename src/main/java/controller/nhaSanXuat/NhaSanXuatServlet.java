package controller.nhaSanXuat;

import entity.ChucVu;
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
import repositories.NhaSanXuatRepository;
import java.io.IOException;
import java.util.Set;

@WebServlet({
        "/nha-san-xuat/index",
        "/nha-san-xuat/create",
        "/nha-san-xuat/store",
        "/nha-san-xuat/edit",
        "/nha-san-xuat/update",
        "/nha-san-xuat/delete"
})
public class NhaSanXuatServlet extends HttpServlet {
    private final NhaSanXuatRepository nhaSanXuatRepo;

    public NhaSanXuatServlet() {
        this.nhaSanXuatRepo = new NhaSanXuatRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().contains("create")){
            this.create(request, response);
        } else if (request.getRequestURI().contains("edit")){
            this.edit(request, response);
        } else if (request.getRequestURI().contains("delete")){
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/nhaSanXuat/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")){
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else  {
            this.index(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            NhaSanXuat nsx = this.nhaSanXuatRepo.findByMa(request.getParameter("ma"));
            BeanUtils.populate(nsx, request.getParameterMap());
            HttpSession session = request.getSession();

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<NhaSanXuat>> constraints = validator.validate(nsx);

            if (!constraints.isEmpty()){
                String errMa = "";
                String errTen = "";
                for (ConstraintViolation<NhaSanXuat> constraintViolation: constraints) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else {
                        errTen = constraintViolation.getMessage();
                    }
                }

                session.setAttribute("nsx", nsx);
                session.setAttribute("errMa", errMa);
                session.setAttribute("errTen", errTen);
                response.sendRedirect("/nha-san-xuat/edit");
            } else {
                this.nhaSanXuatRepo.update(nsx);
                session.removeAttribute("nsx");
                session.removeAttribute("errMa");
                session.removeAttribute("errTen");
                response.sendRedirect("/nha-san-xuat/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/nha-san-xuat/index");
        }
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            NhaSanXuat nsx = new NhaSanXuat();
            BeanUtils.populate(nsx, request.getParameterMap());
            HttpSession session = request.getSession();

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<NhaSanXuat>> constraints = validator.validate(nsx);

            if (!constraints.isEmpty()){
                String errMa = "";
                String errTen = "";
                for (ConstraintViolation<NhaSanXuat> constraintViolation: constraints) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else {
                        errTen = constraintViolation.getMessage();
                    }
                }

                session.setAttribute("nsx", nsx);
                session.setAttribute("errMa", errMa);
                session.setAttribute("errTen", errTen);
                response.sendRedirect("/nha-san-xuat/create");
            } else {
                this.nhaSanXuatRepo.insert(nsx);
                session.removeAttribute("nsx");
                session.removeAttribute("errMa");
                session.removeAttribute("errTen");
                response.sendRedirect("/nha-san-xuat/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/nha-san-xuat/index");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_nsx", this.nhaSanXuatRepo.findAll());
        request.setAttribute("view", "/views/nhaSanXuat/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhaSanXuat nsx = this.nhaSanXuatRepo.findByMa(ma);
        this.nhaSanXuatRepo.delete(nsx);
        response.sendRedirect("/nha-san-xuat/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhaSanXuat nsx = this.nhaSanXuatRepo.findByMa(ma);
        request.setAttribute("nsx", nsx);
        request.setAttribute("view", "/views/nhaSanXuat/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
}
