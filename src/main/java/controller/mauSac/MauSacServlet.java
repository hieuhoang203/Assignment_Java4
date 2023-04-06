package controller.mauSac;

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
import repositories.MauSacRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

@WebServlet({
        "/mau-sac/create",
        "/mau-sac/store",
        "/mau-sac/index",
        "/mau-sac/delete",
        "/mau-sac/edit",
        "/mau-sac/update"
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository mauSacRepository;

    public MauSacServlet() {
        mauSacRepository = new MauSacRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().contains("create")){
            this.create(request, response);
        } else if (request.getRequestURI().contains("edit")) {
            this.edit(request, response);
        } else if (request.getRequestURI().contains("delete")){
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/mauSac/create.jsp");
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
            MauSac ms = this.mauSacRepository.findByMa(request.getParameter("ma"));
            BeanUtils.populate(ms, request.getParameterMap());
            HttpSession session = request.getSession();

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<MauSac>> constraints = validator.validate(ms);

            if (!constraints.isEmpty()){
                String errMa = "";
                String errTen = "";
                for (ConstraintViolation<MauSac> constraintViolation: constraints) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else {
                        errTen = constraintViolation.getMessage();
                    }
                }

                session.setAttribute("ms", ms);
                session.setAttribute("errMa", errMa);
                session.setAttribute("errTen", errTen);
                response.sendRedirect("/mau-sac/edit");
            } else {
                this.mauSacRepository.update(ms);
                session.removeAttribute("ms");
                session.removeAttribute("errMa");
                session.removeAttribute("errTen");
                response.sendRedirect("/mau-sac/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/mau-sac/index");
        }
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            MauSac ms = new MauSac();
            BeanUtils.populate(ms, request.getParameterMap());
            HttpSession session = request.getSession();

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<MauSac>> constraints = validator.validate(ms);

            if (!constraints.isEmpty()){
                String errMa = "";
                String errTen = "";
                for (ConstraintViolation<MauSac> constraintViolation: constraints) {
                    if (constraintViolation.getPropertyPath().toString().equals("ma")){
                        errMa = constraintViolation.getMessage();
                    } else {
                        errTen = constraintViolation.getMessage();
                    }
                }

                session.setAttribute("ms", ms);
                session.setAttribute("errMa", errMa);
                session.setAttribute("errTen", errTen);
                response.sendRedirect("/mau-sac/create");
            } else {
                this.mauSacRepository.insert(ms);
                session.removeAttribute("ms");
                session.removeAttribute("errMa");
                session.removeAttribute("errTen");
                response.sendRedirect("/mau-sac/index");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/mau-sac/index");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_ms", this.mauSacRepository.findAll());
        request.setAttribute("view", "/views/mauSac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac ms = this.mauSacRepository.findByMa(ma);

        this.mauSacRepository.delete(ms);
        response.sendRedirect("/mau-sac/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac ms = this.mauSacRepository.findByMa(ma);
        request.setAttribute("ms", ms);
        request.setAttribute("view", "/views/mauSac/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
}
