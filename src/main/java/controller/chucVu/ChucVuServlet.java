package controller.chucVu;

import entity.ChucVu;
import entity.MauSac;
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
import repositories.ChucVuRepository;

import java.io.IOException;
import java.util.Set;

@WebServlet({
        "/chuc-vu/index",
        "/chuc-vu/create",
        "/chuc-vu/store",
        "/chuc-vu/edit",
        "/chuc-vu/delete",
        "/chuc-vu/update"
})
public class ChucVuServlet extends HttpServlet {
    private final ChucVuRepository chucVuRepository;

    public ChucVuServlet(){
        this.chucVuRepository = new ChucVuRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")){
            this.create(request, response);
        } else if (uri.contains("edit")){
            this.edit(request, response);
        } else if (uri.contains("delete")){
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/chucVu/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ChucVu cv = new ChucVu();
            BeanUtils.populate(cv, request.getParameterMap());
            HttpSession session = request.getSession();

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<ChucVu>> constraints = validator.validate(cv);

            if (!constraints.isEmpty()){
                String errMa = "";
                String errTen = "";
                for (ConstraintViolation<ChucVu> constraintViolation: constraints) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else {
                        errTen = constraintViolation.getMessage();
                    }
                }

                session.setAttribute("cv", cv);
                session.setAttribute("errMa", errMa);
                session.setAttribute("errTen", errTen);
                response.sendRedirect("/chuc-vu/create");
            } else {
                this.chucVuRepository.insert(cv);
                session.removeAttribute("cv");
                session.removeAttribute("errMa");
                session.removeAttribute("errTen");
                response.sendRedirect("/chuc-vu/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/chuc-vu/index");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")){
            this.store(request, response);
        } else if (uri.contains("update")){
            this.update(request, response);
        } else {
            response.sendRedirect("/chuc-vu/index");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ChucVu cv = this.chucVuRepository.findByMa(request.getParameter("ma"));
            BeanUtils.populate(cv, request.getParameterMap());
            HttpSession session = request.getSession();

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<ChucVu>> constraints = validator.validate(cv);

            if (!constraints.isEmpty()){
                String errMa = "";
                String errTen = "";
                for (ConstraintViolation<ChucVu> constraintViolation: constraints) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else {
                        errTen = constraintViolation.getMessage();
                    }
                }

                session.setAttribute("cv", cv);
                session.setAttribute("errMa", errMa);
                session.setAttribute("errTen", errTen);
                response.sendRedirect("/chuc-vu/edit");
            } else {
                this.chucVuRepository.update(cv);
                session.removeAttribute("cv");
                session.removeAttribute("errMa");
                session.removeAttribute("errTen");
                response.sendRedirect("/chuc-vu/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/chuc-vu/index");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_cv", this.chucVuRepository.findAll());
        request.setAttribute("view", "/views/chucVu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cv = this.chucVuRepository.findByMa(ma);
        this.chucVuRepository.delete(cv);
        response.sendRedirect("/chuc-vu/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cv = this.chucVuRepository.findByMa(ma);

        request.setAttribute("cv", cv);
        request.setAttribute("view", "/views/chucVu/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
}
