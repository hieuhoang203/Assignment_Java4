package controller.dongSp;

import entity.DongSp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.DongSanPhamRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/dong-sp/create",
        "/dong-sp/index",
        "/dong-sp/delete",
        "/dong-sp/update",
        "/dong-sp/edit",
        "/dong-sp/store"
})
public class DongSpServlet extends HttpServlet {
    private final DongSanPhamRepository dongSanPhamRepository;

    public DongSpServlet() {
        dongSanPhamRepository = new DongSanPhamRepository();
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
        request.setAttribute("view", "/views/dongSp/create.jsp");
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
            response.sendRedirect("/dong-sp/index");
        }
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DongSp dongSp = new DongSp();
            BeanUtils.populate(dongSp, request.getParameterMap());
            this.dongSanPhamRepository.insert(dongSp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/dong-sp/index");
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_dsp", this.dongSanPhamRepository.findAll());
        request.setAttribute("view", "/views/dongSp/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        DongSp dongSp = this.dongSanPhamRepository.findByMa(ma);

        this.dongSanPhamRepository.delete(dongSp);
        response.sendRedirect("/dong-sp/index");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSp dongSp = this.dongSanPhamRepository.findByMa(ma);

        request.setAttribute("dongSp", dongSp);
        request.setAttribute("view", "/views/dongSp/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            DongSp dongSp = this.dongSanPhamRepository.findByMa(request.getParameter("ma"));
            BeanUtils.populate(dongSp, request.getParameterMap());
            this.dongSanPhamRepository.update(dongSp);
        } catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/dong-sp/index");
    }
}
