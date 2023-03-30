package controller.cuaHang;

import entity.CuaHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.CuaHangRepository;

import java.io.IOException;

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
            this.cuaHangRepository.update(ch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/cua-hang/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CuaHang ch = new CuaHang();
            BeanUtils.populate(ch, request.getParameterMap());
            this.cuaHangRepository.insert(ch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/cua-hang/index");
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
